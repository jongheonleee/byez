package com.neo.byez.service.order;

import com.neo.byez.dao.*;
import com.neo.byez.dao.order.*;
import com.neo.byez.domain.*;
import com.neo.byez.domain.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    // 주문관련 Dao
    @Autowired
    OrderDaoImpl orderDao;
    @Autowired
    OrderDetailDaoImpl orderDetailDao;
    @Autowired
    OrderStateDaoImpl orderStateDao;

    // 결제관련 Dao
    @Autowired
    PayDaoImpl payDao;
    @Autowired
    PayStateDaoImpl payStateDao;
    @Autowired
    PayHistoryDaoImpl payHistoryDao;

    // 배송관련 Dao
    @Autowired
    DeliveryDaoImpl deliveryDao;

    // 주문상세 페이지 정보 생성
    /*
        주문번호로 주문상세정보 조회
            1. 주문상세정보(주문, 배송테이블) 조회
                1-1. 실패 : 반환값이 null이면 실패
                1-2. 성공 :
            2. 주문상품내역목록 조회
                2-1. 실패 : 반환된 리스트의 사이즈가 0이면 실패
                2-2. 성공 :
            3. 주문 상세정보 반환
     */
    public OrderResultInfo getOrderCompleteInfo(String ord_num) {
        OrderResultInfo orderResultInfo = new OrderResultInfo();
        try {
            orderResultInfo = orderDao.selectOrderResult(ord_num);
            orderResultInfo.setOrderDetailDtoList(orderDetailDao.select(ord_num));

            if (orderResultInfo == null || orderResultInfo.getOrderDetailDtoList().size() == 0){
                throw new Exception("Order Info or OrderDetail Info is Null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return orderResultInfo;
    }

    // 주문번호 생성
    public synchronized String orderNumGenerator(){
        try {
            // 쓰레드를 1mills 재운다.
            Thread.sleep(1);

            // 현재 시간 구하기
            LocalDateTime srcTime = LocalDateTime.now();

            // 포맷 정의
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
            // 포맷해서 반환
            return srcTime.format(formatter);
        } catch (Exception e) {
            e.printStackTrace();
            // InterruptedException 또는 Exception 발생 시 빈문자열 반환
            return "";
        }
    }


    /*
        결제 요청 전 주문 정보 저장
            1. 주문 정보 검증
            2. 주문 정보 초기화
            3. 주문 정보 저장
    */
    // 결제 요청 전 주문관련정보 저장
    @Transactional(rollbackFor = {Exception.class})
    public void saveOrderInfo(OrderReadyInfo orderReadyInfo, String id) throws Exception {
        // 주문 정보 검증
        if(!validateOrderInfo(orderReadyInfo)){
            throw new Exception("Failed Validate Order Info");
        }

        // 주문 정보 초기화
        orderReadyInfo.initOrderReadyInfo(id, "주문대기", "결제대기");

        // 성공 결과를 판단하기 위한 변수
        int result = 0;

        // insert Tx
        // 주문관련 insert Tx
        result += insertOrderWithTx(orderReadyInfo.getOrderDto(), orderReadyInfo.getOrderDetailDtoList(), orderReadyInfo.getOrderStateDto());
        // 결제관련 insert Tx
        result += insertPayWithTx(orderReadyInfo.getPayDto(), orderReadyInfo.getPayStateDto());
        // 배송관련 insert
        result += deliveryDao.insert(orderReadyInfo.getDeliveryDto());

        // 결과가 3이 아니면 실패
        if (result != 3){
            throw new Exception("Order, Pay, Delivery Info Save Failed");
        }
    }

    // 주문관련 데이터 insert Tx
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertOrderWithTx(OrderDto orderDto, List<OrderDetailDto> orderDetailDtoList, OrderStateDto orderStateDto) throws Exception{
        // 성공 결과를 판단하기 위한 변수
        int result = 0;
        // 주문정보 저장
        result += orderDao.insert(orderDto);
        // 주문상품정보 저장
        for(OrderDetailDto dto : orderDetailDtoList){
            result += orderDetailDao.insert(dto);
        }
        // 주문진행상태 저장
        result += orderStateDao.insert(orderStateDto);
        if(result != 2+orderDetailDtoList.size()){
            throw new Exception("Order Info Insert Tx Failed");
        }
        return 1;
    }

    // 결제관련 데이터 insert Tx
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertPayWithTx(PayDto payDto, PayStateDto payStateDto) throws Exception{
        // 성공여부를 판단하기 위한 변수
        int result = 0;
        // 결제정보 저장
        result += payDao.insert(payDto);
        // 결제진행상태 저장
        result += payStateDao.insert(payStateDto);

        // insert가 하나라도 실패하면
        if (result != 2){
            // 예외 발생
            throw new Exception("Pay Info Insert Tx Failed");
        }
        return 1;
    }

    // 주문정보 유효성 검증
    /*
        주문 데이터 유효성 검증
        고객이 주문한 금액이 유효한 가격인지 확인

            #. 총 주문금액 유효성
                1. 상품번호로 (상품단가 * 수량) 주문상품 금액 도출
                2. 주문 상품목록의 총 주문상품금액 도출
                3. 입력 받은 총 주문상품금액과 비교
            #. 할인금액 유효성
                1. 쿠폰번호(고객아이디 + seq)로 쿠폰 조회  사용여부 - 유효한지
                2. 할인금액을 계산
                3. 입력 받은 할인금액과 비교
            #. 결제금액 유효성
                1. (총 주문상품금액 - 총 할인금액 = 결제금액)
                2. 입력 받은 결제금액과 비교
     */
    public boolean validateOrderInfo(OrderReadyInfo orderReadyInfo){
        // 검증할 데이터(입력 받은 데이터)
        // 주문 Dto
        OrderDto orderDto = orderReadyInfo.getOrderDto();
        // 주문상품 Dto 리스트
        List<OrderDetailDto> orderDetailDtoList = orderReadyInfo.getOrderDetailDtoList();
        // 총 결제금액
        int totalPayPrice = orderDto.getTotal_pay_price();

        // 검증 결과 반환
        return validateTotalPayPrice(orderDto, orderDetailDtoList, totalPayPrice);
    }

    // 총 결제금액 유효성 검증
    // 총 결제금액이 계산한 값과 일치하는가
    public boolean validateTotalPayPrice(OrderDto orderDto, List<OrderDetailDto> orderDetailDtoList, int totalPayPrice){
        // 주문상품 금액 유효성 검증
        int totalPrice = validateTotalPrice(orderDto, orderDetailDtoList);
        // 할인금액 유효성 검증
        int totalDiscountPrice = validateDiscountPrice();
        // 계산한 값과 일치하는가
        return (totalPrice-totalDiscountPrice) == totalPayPrice;
    }

    // 할인금액 유효성 검증
        /*
            무엇을 검증하는가.
                1. 쿠폰이 사용가능한가.
                2. 최소주문금액 조건을 만족하는가
                3. 최대 할인 금액을 넘지 않는가.
                4. 입력받은 할인금액과 일치하는가

            1. 주문에서 총 주문상품금액을 구한다.
            2. 쿠폰번호로 쿠폰Dto를 구한다.
            3. 쿠폰Dto의 상태, 최소주문금액, 할인율을 구한다.
            4. 쿠폰 Dto의 상태가 사용가능한지 확인.
            5. 총 주문상품금액이 최소주문금액보다 큰지 확인
            6. 입력 받은 할인금액이 최대 할인금액이 넘지 않는지 확인
            7. (총 주문상품금액 * 0.할인율) 할인금액 계산
            8. 입력받은 할인금액과 계산한 값이 일치하는가
         */
    // 쿠폰 파트에서 구현 예정
    public int validateDiscountPrice(){
        return 0;
    }

    // 총 주문금액 유효성 검증
    /*
            1. 주문상품에서 상품번호를 구한다.
            2. 주문에서 총 주문상품금액을 구한다.
            3. 상품번호로 상품Dto를 얻는다.
            4. 상품Dto의 상품단가를 구한다.
            5. 결과에 상품단가 * qty를 더하여 저장
            6. 5번을 반복
            7. 결과와 총 주문상품금액 비교
                7-1. 같으면 성공
                7-2. 다르면 실패
         */
    public int validateTotalPrice(OrderDto orderDto, List<OrderDetailDto> orderDetailDtoList){
        // 주문에서 총 주문상품금액을 구한다.
        int total_price = orderDto.getTotal_price();
        int sum = 0;

        for(OrderDetailDto orderDetailDto : orderDetailDtoList){
            // 주문상품에서 상품번호를 구한다.
//            int item_num = orderDetailDto.getItem_num();

            // 주문상품에서 수량을 구한다.
            int qty = orderDetailDto.getItem_qty();

            // 상품번호로 상품Dto를 얻는다.
            // ProductDto productDto = productDao.select(item_num);

            // 상품Dto에서 상품단가를 구한다.
            int price = orderDetailDto.getPrice();
            // price = productDto.getPrice();

            // sum에 (상품단가 * qty)를 더하여 저장
            sum += (price * qty);
        }
        // 같으면 검증 통과, 다르면 실패
        return (sum == total_price) ? total_price : -1;
    }

    // 주문 정보 초기값 설정
//    public void initOrderReadyInfo(OrderReadyInfo orderReadyInfo, String id){
//        // 주문 Dto
//        OrderDto orderDto = orderReadyInfo.getOrderDto();
//        orderDto.setSaveReadyInfo(id);
//
//        // 주문번호
//        String ord_num = orderDto.getOrd_num();
//
//        // 주문 상품 Dto
//        List<OrderDetailDto> orderDetailDtoList = orderReadyInfo.getOrderDetailDtoList();
//        for (OrderDetailDto orderDetailDto : orderDetailDtoList){
//            orderDetailDto.setOrd_num(ord_num);
//            orderDetailDto.setSaveReadyInfo(id);
//        }
//
//        // 주문 상태 Dto
//        OrderStateDto orderStateDto = orderReadyInfo.getOrderStateDto();
//        orderStateDto.setSaveReadyInfo(id, 1, ord_num, "주문대기");
//
//        // 결제 Dto
//        PayDto payDto = orderReadyInfo.getPayDto();
//        payDto.setSaveReadyInfo(id);
//        payDto.setOrd_num(ord_num);
//
//        // 결제번호
//        String pay_num = payDto.getPay_num();
//
//        // 결제 상태 Dto
//        PayStateDto payStateDto = orderReadyInfo.getPayStateDto();
//        payStateDto.setSaveReadyInfo(id, 1, pay_num, "PAY1");
//
//        // 배송관련 Dto
//        DeliveryDto deliveryDto = orderReadyInfo.getDeliveryDto();
//        deliveryDto.setSaveReadyInfo(id);
//        deliveryDto.setOrd_num(ord_num);
//    }
//
//    public HashMap<String, Object> jsonToObjectMap(HashMap<String, Object> jsonMap) throws JsonProcessingException {
//        // ObjectMapper 생성
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // orderDto 파싱
//        Object obj = jsonMap.get("orderDto");
//        String str = objectMapper.writeValueAsString(obj);
//        OrderDto orderDto = objectMapper.readValue(str, OrderDto.class);
//        jsonMap.put("orderDto", orderDto);
//
//        // orderDetailDtoList 파싱
//        ArrayList<Object> objList = (ArrayList<Object>) jsonMap.get("orderDetailDtoList");
//        str = objectMapper.writeValueAsString(objList);
//        List<OrderDetailDto> orderDetailDtoList = Arrays.asList(objectMapper.readValue(str, OrderDetailDto[].class));
//        jsonMap.put("orderDetailDtoList", orderDetailDtoList);
//
//        // orderStateDto 생성
//        String ord_num = orderDto.getOrd_num();
//        String id = orderDto.getId();
//        OrderStateDto orderStateDto = new OrderStateDto(ord_num, 1, "ORD1", id);
//        orderStateDto.setReg_id(id);
//        orderStateDto.setUp_id(id);
//        jsonMap.put("orderStateDto", orderStateDto);
//
//        // deliveryDto 파싱
//        obj = jsonMap.get("deliveryDto");
//        str = objectMapper.writeValueAsString(obj);
//        DeliveryDto deliveryDto = objectMapper.readValue(str, DeliveryDto.class);
//        deliveryDto.setReg_id(id);
//        deliveryDto.setUp_id(id);
//        jsonMap.put("deliveryDto", deliveryDto);
//
//        // payDto 파싱
//        obj = jsonMap.get("payDto");
//        str = objectMapper.writeValueAsString(obj);
//        PayDto payDto = objectMapper.readValue(str, PayDto.class);
//        payDto.setReg_id(id);
//        payDto.setUp_id(id);
//        jsonMap.put("payDto", payDto);
//
//        // payStateDto 생성
//        String pay_num = payDto.getPay_num();
//        PayStateDto payStateDto = new PayStateDto(pay_num, 1, "PAY1");
//        payStateDto.setReg_id(id);
//        payStateDto.setUp_id(id);
//        jsonMap.put("payStateDto", payStateDto);
//
//        return jsonMap;
//    }

}
