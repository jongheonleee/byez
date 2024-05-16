package com.neo.byez.service.order;

import com.neo.byez.dao.order.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderServiceImplTest {
    private final OrderServiceImpl orderService;
    private final OrderDaoImpl orderDao;
    private final OrderDetailDaoImpl orderDetailDao;
    private final OrderStateDaoImpl orderStateDao;
    private final DeliveryDaoImpl deliveryDao;
    private final PayDaoImpl payDao;
    private final PayStateDaoImpl payStateDao;

    @Autowired
    public OrderServiceImplTest(OrderServiceImpl orderService, OrderDaoImpl orderDao, OrderDetailDaoImpl orderDetailDao, OrderStateDaoImpl orderStateDao, DeliveryDaoImpl deliveryDao, PayDaoImpl payDao, PayStateDaoImpl payStateDao) {
        this.orderService = orderService;
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
        this.orderStateDao = orderStateDao;
        this.deliveryDao = deliveryDao;
        this.payDao = payDao;
        this.payStateDao = payStateDao;
    }

    /*
        테스트 환경 테스트
            1. 빈에 정상 등록 되었는가
     */
    @Test
    public void 환경초기화테스트() throws Exception{
        assertTrue(orderService != null);
        assertTrue(orderService instanceof OrderServiceImpl);
        assertTrue(orderService instanceof OrderService);
        assertTrue(orderDao != null);
        assertTrue(orderDetailDao != null);
        assertTrue(orderStateDao != null);
        assertTrue(deliveryDao != null);
        assertTrue(payDao != null);
        assertTrue(payStateDao != null);

        tableInitAll();
        tableCountAll_num(0);
    }

    /*
        주문상세 페이지 정보
        SELECT 테스트

        실패 조건
            1. 주문번호가 없는 경우 반환값 null
            2. 결과가 여러개인 경우 - 없을 거 같음 why. where 조건에 주문번호가 일치하는 것을 조회
     */

    @DisplayName("주문상세페이지 정보 SELECT 테스트")
    @Test
    public void orderResultInfoSelectTest() throws Exception {
        // 테이블 초기화

        String ord_num = "202405141958127607";
        System.out.println(orderService.getOrderCompleteInfo(ord_num));
    }

    /*
        주문 서비스 테스트
        무엇을, 어떻게 테스트 할 것인가

        1. 각 메서드가 정상적으로 동작하는가
        2. 예외가 발생할 가능성은 없는가
        3. 예상한 값이 나올 가능성은 없는가
        4. 실패했을 때 어떻게 처리되는가

        메서드 종류
        1. 주문번호 생성
        2. 주문정보 검증
        3. 주문정보 객체 초기화
        4. 주문정보 저장 트랜잭션

        1. 주문번호 생성
            1. 주문 번호가 형식대로 생성되는가.
            2. 동시에 많은 요청이 들어왔을때 유일성이 보장되는가

        2. 주문정보 검증
            1. 정상적인 정보이면 성공을 반환하는가
            2. 비정상적인 정보이면 실패를 반환하는가

        3. 주문정보 객체 초기화
            1. 필수값들이 있는가
     */


    /*
        1. 주문번호 생성
            X 1. 주문 번호가 형식대로 생성되는가.
            2. 동시에 많은 요청이 들어왔을때 유일성이 보장되는가

        시나리오 1
            1. 10개의 쓰레드를 생성한다.
            2. 동시에 주문번호를 생성한다.
            3. 10개의 서로 다른 주문번호가 생성 됐는지 확인

        성공 조건
            1. 동시에 여러 쓰레드에서 호출해도 유일한 값이어야 함
     */

    @DisplayName("주문번호생성 동시성테스트")
    @Test
    public void generatorOrderNumber(){
        // 주문번호 담을 리스트 생성
        List<String> orderNums = new ArrayList<>();

        // 총 10개의 쓰레드를 담는 쓰레드 풀 생성
        int numbersOfThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numbersOfThreads);

        for (int i = 0; i < numbersOfThreads; i++){
            // 쓰레드 실행
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    // 주문번호를 생성해서 리스트에 저장
                    orderNums.add(orderService.orderNumGenerator());
                }
            });
        }
        // executorService 종료
        executorService.shutdown();
        // 종료되지 않았으면 대기
        while (!executorService.isTerminated()) {
            // 대기
        }

        // 중복된 값이 있는지 체크
        // Set으로 변환하여 사이즈가 다른지 비교
        HashSet<String> orderNumSet = new HashSet<>(orderNums);
        assertTrue(orderNums.size() == orderNumSet.size());
    }

    /*
        Tx TEST
        트랜잭션 테스트
        ※ 실패하면 예외 발생

        성공조건
            1. 주문번호, 결제번호, 배송번호가 있어야 함.
            2. PK 먼저 생성하고 FK로 참조되어야 함.
            3. NOT NULL 컬럼에 해당하는 값이 있어야 함.
            4. 자동 형변환이 안되는 값이 들어가면 안됨.
            5. 컬럼의 길이가 초과되는 값이 들어가면 안됨.

        실패조건
            1. PK가 없는 경우
            2. FK가 없는 PK를 참조
            3. NOT NULL 컬럼에 NULL
            4. 타입 자동형변환이 안되는 값
            5. 컬럼의 길이를 초과한 값

        테스트 방식
            1. 주문 - 주문상품 - 주문진행상태 - 결제 - 결제진행상태 - 배송 순으로 데이터 저장
            2. 중간에 예외 발생시키고 롤백 확인
            3. 정상 수행되었을 때 커밋 확인

        시나리오
            1. 성공조건을 모두 만족하는 경우
            2. 실패 조건을 모두 만족하는 경우
            3. 실패 조건을 하나씩 만족하는 경우
    */

    // Tx TEST
    // 시나리오 1. 성공조건을 모두 만족하는 경우
    /*
        시나리오 1 상세

        1. 테스트 데이터 생성
        2. 기능 실행
        3. 커밋 확인
    */
//    @DisplayName("성공_트랜잭션테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
//    public void saveOrderTest_Success(int num) throws Exception {
//        // 전체 테이블 초기화
//        tableInitAll();
//
//        // 초기화 됐는지 확인
//        tableCountAll_num(0);
//
//        // 비교기준값(DB 저장 전)
//        // 1. 테스트 데이터 생성
//        // 테스트 Dto
//        OrderDto orderDto = makeDummyOrderDto(num);
//        List<OrderDetailDto> orderDetailDtoList = makeDummyOrderDetailDtoList(num);
//        OrderStateDto orderStateDto = makeDummyOrderStateDto(num);
//        DeliveryDto deliveryDto = makeDummyDeliveryDto(num);
//        PayDto payDto = makeDummyPayDto(num);
//        PayStateDto payStateDto = makeDummyPayStateDto(num);
//
//        // 조회 하는데 사용할 주문번호
//        String ord_num = orderDto.getOrd_num();
//        // 조회 하는데 사용할 결제번호
//        String pay_num = payDto.getPay_num();
//        String dlv_num = deliveryDto.getDlv_num();
//
//        // Map으로 전달
//        HashMap<String, Object> map = makeOrderInfoMap(orderDto, orderDetailDtoList, orderStateDto, deliveryDto, payDto, payStateDto);
//
//        // 주문 정보 저장 시도....!!
////        assertTrue(orderService.saveOrder(map) == 1);
//        orderService.saveOrder(map);
//
//        // Commit이 성공적으로 됐는지 조회
//        assertTrue(orderDao.select(ord_num) != null);
//        assertTrue(payDao.select(pay_num) != null);
//
//        // 비교대상값(DB에 저장된 값)
//        OrderDto target_orderDto = orderDao.select(ord_num);
//        List<OrderDetailDto> target_List = orderDetailDao.select(ord_num);
//        OrderStateDto target_orderStateDto = orderStateDao.select(ord_num).get(0);
//        DeliveryDto target_deliveryDto = deliveryDao.select(dlv_num);
//        PayDto target_payDto = payDao.select(pay_num);
//        PayStateDto target_payStateDto = payStateDao.select(pay_num).get(0);
//
//        // 비교기준값(DB저장 전)과 비교대상값(DB 저장된 값)을 비교
//        assertTrue(orderDto.equals(target_orderDto));
//        assertTrue(orderDetailDtoList.get(0).equals(target_List.get(0)));
//        assertTrue(orderStateDto.equals(target_orderStateDto));
//        assertTrue(deliveryDto.equals(target_deliveryDto));
//        assertTrue(payDto.equals(target_payDto));
//        assertTrue(payStateDto.equals(target_payStateDto));
//   }
//
//    // Tx TEST
//    // 시나리오 2. 실패조건을 모두 만족하는 경우
//    /*
//        시나리오 2 상세
//
//        1. 테스트 데이터 생성
//        2. 기능 실행
//        3. 롤백 확인
//    */
//    @DisplayName("실패_트랜잭션테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {0})
////    @ValueSource(ints = {0})
//   public void saveOrderTest_Failed(int num) throws Exception{
//        // 전체 테이블 초기화
//        tableInitAll();
//
//        // 초기화 됐는지 확인
//        tableCountAll_num(0);
//
//        // 비교기준값(DB 저장 전)
//        // 1. 테스트 데이터 생성
//        HashMap<String, Object> map = makeDummyOrderInfoMap(num);
//
//        // PK가 없는 데이터 생성
////        OrderDto orderDto = new OrderDto();
//        PayDto payDto = new PayDto();
////        OrderStateDto orderStateDto = (OrderStateDto) map.get("orderStateDto");
////        orderStateDto.setReg_id(null);
//        payDto.setPay_date(null);
//        map.put("payDto", payDto);
//
//        // NOT NULL(PK) 컬럼에 NULL 값 삽입 테스트
//        try {
//            orderService.saveOrder(map);
//        } catch (DataIntegrityViolationException e){
//            e.printStackTrace();
//        }
//        // 롤백됐는지 확인
//        tableCountAll_num(0);
////
////        // 전체 테이블 초기화
////        tableInitAll();
////        tableCountAll_num(0);
////
////        // 중복된 값
////        map = makeDummyOrderInfoMap(num);
////
////        try {
////            orderService.saveOrder(map);
////            orderService.saveOrder(map);
////        } catch (DuplicateKeyException e){
////        }
////        // 롤백됐는지 확인
////        tableCountAll_num(1);
//    }

    public void tableCountAll_num(int num) throws Exception {
        assertTrue(orderDao.countAll()==num);
        assertTrue(orderDetailDao.countAll()==num);
        assertTrue(orderStateDao.countAll()==num);
        assertTrue(deliveryDao.count()==num);
        assertTrue(payDao.count()==num);
        assertTrue(payStateDao.count()==num);
    }


   public void tableInitAll() throws Exception {
        orderDao.deleteAll();
        orderDetailDao.deleteAll();
        orderStateDao.deleteAll();
        deliveryDao.deleteAll();
        payDao.deleteAll();
        payStateDao.deleteAll();
   }

//    HashMap<String, Object> makeDummyOrderInfoMap(int num){
//        OrderDto orderDto = makeDummyOrderDto(num);
//        List<OrderDetailDto> orderDetailDtoList = makeDummyOrderDetailDtoList(0);
//        OrderStateDto orderStateDto = makeDummyOrderStateDto(num);
//        DeliveryDto deliveryDto = makeDummyDeliveryDto(num);
//        PayDto payDto = makeDummyPayDto(num);
//        PayStateDto payStateDto = makeDummyPayStateDto(num);
//
//        // Map으로 전달
//        return makeOrderInfoMap(orderDto, orderDetailDtoList, orderStateDto, deliveryDto, payDto, payStateDto);
//    }
//
//    public HashMap<String, Object> makeOrderInfoMap(OrderDto orderDto, List<OrderDetailDto> orderDetailDtoList, OrderStateDto orderStateDto, DeliveryDto deliveryDto, PayDto payDto, PayStateDto payStateDto){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("orderDto", orderDto);
//        map.put("orderDetailDtoList", orderDetailDtoList);
//        map.put("orderStateDto", orderStateDto);
//        map.put("deliveryDto", deliveryDto);
//        map.put("payDto", payDto);
//        map.put("payStateDto", payStateDto);
//        return map;
//    }
//
//    public PayStateDto makeDummyPayStateDto(int num){
//        PayStateDto dto = new PayStateDto();
//        dto.setPay_num("TestPay_num-" + num);
//        dto.setSeq(num);
//        dto.setState_code("결제대기");
//        dto.setReg_id("TestID");
//        dto.setUp_id("TestID");
//        return dto;
//    }
//
//    public PayDto makeDummyPayDto(int num){
//        PayDto dto = new PayDto();
//        dto.setPay_num("TestPay_num-" + num);
//        dto.setOrd_num("TestOrd_num-" + num);
//        dto.setPrice(10000 + num);
//        dto.setMtd_code("PMT03");
//        dto.setPay_date("2024-04-29 12:00:00"); // NOT NULL NULL로 수정해야함
//        dto.setState("결제대기");
//        dto.setReg_id("TestID");
//        dto.setUp_id("TestID");
//        return dto;
//    }
//
//    public DeliveryDto makeDummyDeliveryDto(int num){
//        DeliveryDto dto = new DeliveryDto();
//        dto.setDlv_num("TestDlv_num-" + num);
//        dto.setOrd_num("TestOrd_num-" + num);
//        dto.setPickup_chk("N");
//        dto.setRcpr("TestRcpr");
//        dto.setRcpr_mobile("010-1234-5678");
//        dto.setZpcd("00"+num);
//        dto.setMain_addr("서울시 강남구");
//        dto.setDetail_addr("미왕빌딩 10층" + num + "강의실");
//        dto.setStart_date("20240430");
//        dto.setEnd_date("20240505");
//        dto.setState("배송준비중");
//        dto.setReg_date("20240429");
//        dto.setReg_id("TestID");
//        dto.setUp_date("20240429");
//        dto.setUp_id("TestID");
//        return dto;
//    }
//
//    public OrderStateDto makeDummyOrderStateDto(int num){
//        OrderStateDto dto = new OrderStateDto();
//        dto.setOrd_num("TestOrd_num-" + num);
//        dto.setSeq(num);
//        dto.setState_code("주문완료");
//        dto.setReg_id("TestID");
//        dto.setUp_id("TestID");
//        return dto;
//    }
//
//    public List<OrderDetailDto> makeDummyOrderDetailDtoList(int num){
//        List<OrderDetailDto> list = new ArrayList<>();
//        for (int i=0; i <= num; i++){
//            OrderDetailDto dto = makeDummyOrderDetailDto(num);
//            dto.setSeq(i);
//            list.add(dto);
//        }
//        return list;
//    }
//
//    public OrderDetailDto makeDummyOrderDetailDto(int num){
//        OrderDetailDto dto = new OrderDetailDto();
//        dto.setOrd_num("TestOrd_num-" + num);
//        dto.setSeq(num);
//        dto.setItem_num(num);
//        dto.setId("TestID" + num);
//        dto.setItem_name("TestItem" + num);
//        dto.setPrice(10000 + num);
//        dto.setItem_qty(num%5 == 0 ? 1:num%5);
//        dto.setItem_price(10000 + num);
//        dto.setReg_id("TestID");
//        dto.setUp_id("TestID");
//        return dto;
//    }
//
//    public OrderDto makeDummyOrderDto(int num){
//        String ord_num = ("TestOrd_num-" + num);
//        String id = "TestID" + num;
//        Integer total_item_qty = num%3;
//        Integer total_price = 20000 + num;
//        Integer total_dlv_price = 2500 + num;
//        Integer total_disc_price = 0 + num;
//        Integer total_pay_price = 17500 + num;
//        String ord_state = "주문완료" + num;
//        return new OrderDto(ord_num, id, total_item_qty, total_price, total_dlv_price, total_disc_price, total_pay_price, ord_state);
//    }

}