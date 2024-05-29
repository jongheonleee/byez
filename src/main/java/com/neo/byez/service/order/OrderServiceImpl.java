package com.neo.byez.service.order;

import com.neo.byez.dao.*;
import com.neo.byez.dao.item.BasketItemDaoImpl;
import com.neo.byez.dao.order.*;
import com.neo.byez.domain.*;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    // 주문관련 Dao
    private OrderDaoImpl orderDao;
    private OrderDetailDaoImpl orderDetailDao;
    private OrderStateDaoImpl orderStateDao;
    // 결제관련 Dao
    private PayDaoImpl payDao;
    private PayStateDaoImpl payStateDao;
    private PayHistoryDaoImpl payHistoryDao;
    // 배송관련 Dao
    private DeliveryDaoImpl deliveryDao;
    // 장바구니 Dao
    private BasketItemDaoImpl basketItemDao;
    // 배송지목록 Dao
    private AddrListDaoImpl addrListDao;
    private CustCouponsDaoImpl custCouponsDao;
    @Autowired
    public OrderServiceImpl(OrderDaoImpl orderDao, OrderDetailDaoImpl orderDetailDao, OrderStateDaoImpl orderStateDao, PayDaoImpl payDao, PayStateDaoImpl payStateDao, PayHistoryDaoImpl payHistoryDao, DeliveryDaoImpl deliveryDao, BasketItemDaoImpl basketItemDao, AddrListDaoImpl addrListDao, CustCouponsDaoImpl custCouponsDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
        this.orderStateDao = orderStateDao;
        this.payDao = payDao;
        this.payStateDao = payStateDao;
        this.payHistoryDao = payHistoryDao;
        this.deliveryDao = deliveryDao;
        this.basketItemDao = basketItemDao;
        this.addrListDao = addrListDao;
        this.custCouponsDao = custCouponsDao;
    }

    // 주문 폼 페이지 정보 생성
    public HashMap<String, Object> orderForm(String id, List<BasketItemDto> basketItemDtoList) throws Exception {
        // HashMap 만들기
        HashMap<String, Object> map = new HashMap<>();

        // 총 상품수량, 총 주문상품금액 계산
        OrderDto orderDto = makeOrderDto(basketItemDtoList);
        // 배송지 목록 조회
        List<AddressEntryDto> addressEntryDtoList = addrListDao.selectById(id);

        map.put("orderDto", orderDto);
        map.put("addressEntryDtoList", addressEntryDtoList);

        return map;
    }

    // 장바구니 상품 가격 계산 후 주문정보 객체 생성
    public OrderDto makeOrderDto(List<BasketItemDto> basketItemDtoList){
        OrderDto orderDto = new OrderDto();
        int totalQty = 0;
        int totalPrice = 0;
        for (BasketItemDto basketItemDto : basketItemDtoList){
            int qty = basketItemDto.getQty();
            int price = basketItemDto.getPrice();
            totalQty += qty;
            totalPrice +=  (price * qty);
        }
        orderDto.setTotal_item_qty(totalQty);
        orderDto.setTotal_price(totalPrice);
        // 추후 할인금액 계산해서 넘길지 고려
        orderDto.setTotal_pay_price(totalPrice);

        return orderDto;
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

    // 주문 성공 시 업데이트
    @Transactional(rollbackFor = {Exception.class})
    public int modifyOrder(String ord_num, String state) throws Exception {
        try {
            // 주문 번호로 주문, 주문 상품상세 업데이트
            OrderDto orderDto = orderDao.select(ord_num);
            List<OrderDetailDto> orderDetailDtoList = orderDetailDao.select(ord_num);

            // 주문 상태 업데이트
            orderDto.setOrd_state(state);

            // 주문상품상세 상태 업데이트
            for(OrderDetailDto orderDetailDto : orderDetailDtoList){
                orderDetailDto.setOrd_state(state);
                orderDetailDao.update(orderDetailDto);
            }

            // 주문 상태 추가
            String id = orderDto.getId();
            Integer seq = orderStateDao.count(ord_num) + 1;

            OrderStateDto orderStateDto = new OrderStateDto(ord_num, seq, state, id);
            orderStateDao.insert(orderStateDto);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    // 주문번호로 장바구니 상품 삭제
    public int removeBasketItemByOrderNum(String ord_num, String id) {
        /*
            주문번호로 주문상세리스트 조회
            시퀀스로 basketItemDto로 삭제
         */
        try {
            // 주문번호로 주문상품 내역 조회
            List<OrderDetailDto> orderDetailDtoList = orderDetailDao.select(ord_num);
            for(OrderDetailDto orderDetailDto : orderDetailDtoList){
                BasketItemDto basketItemDto = new BasketItemDto();
                int seq = orderDetailDto.getSeq();
                basketItemDto.setId(id);
                basketItemDto.setSeq(seq);

                // 장바구니 상품 삭제
                basketItemDao.delete(basketItemDto);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
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
//        if(!validateOrderInfo(orderReadyInfo)){
//            throw new Exception("Failed Validate Order Info");
//        }

        // 주문 정보 초기화
        orderReadyInfo.initOrderReadyInfo(id, "주문완료", "결제대기");

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
}
