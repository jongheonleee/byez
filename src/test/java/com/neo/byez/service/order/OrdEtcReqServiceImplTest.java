package com.neo.byez.service.order;

import com.neo.byez.dao.order.*;
import com.neo.byez.domain.order.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //설정파일 찾기
public class OrdEtcReqServiceImplTest {

    @Autowired
    OrdEtcReqServiceImpl ordEtcReqService;
    @Autowired
    OrderDetailDaoImpl orderDetailDao;
    @Autowired
    OrderDaoImpl orderDao;
    @Autowired
    OrderStateDaoImpl orderStateDao;
    @Autowired
    OrdEtcReqDaoImpl ordEtcReqDao;
    @Autowired
    DeliveryDaoImpl deliveryDao;
//
//
//
//    //의존성주입테스트
//    @Test
//    public void test(){
//        assertTrue(orderDetailDao != null);
//        assertTrue(orderDao != null);
//        assertTrue(orderStateDao != null);
//        assertTrue(ordEtcReqDao != null);
//        assertTrue(deliveryDao != null);
//        assertTrue(ordEtcReqService != null);
//    }
//
//    @Test
//    public void 취소테스트환경세팅() throws Exception {
//        //1. orderState 테이블 초기화
//        cleanStateDB();
//        //2. 주문취소 테이블 초기화
//        cleanEtcDB();
//        //3. 주문내역 테이블의 주문상태컬럼 초기화
//        initOrdDetail();
//        //4. 주문테이블의 주문상태컬럼 초기화
//        initOrder();
//        //5. 배송테이블도 초기화해야할까..
//    }
//    @Test
//    public void 반품테스트환경세팅()throws Exception{
//        cleanStateDB();
//        cleanEtcDB();
//        initOrdDetailForRefundTest();
//        initOrderForRefundTest();
//    }
//
//    @Test
//    public void 취소중복에러_테스트환경세팅() throws Exception {
//        //같은 주문번호의 주문취소내역은 초기화하지 않고 중복 insert 테스트
//
//        //1. orderState 테이블 초기화
//        cleanStateDB();
//        //2. 주문내역 테이블의 주문상태컬럼 초기화
//        initOrdDetail();
//        //3. 주문테이블의 주문상태컬럼 초기화
//        initOrder();
//    }
//
//        //필요객체와 setter
//        //1. OrdEtcReqDto -> 주문취소교환반품 테이블에 insert
//        //2. OrdDetailDto -> 주문번호가 20240503-0001인 주문내역의 주문상태를 업데이트한다
//        //3. OrderDto -> 주문번호가 20240503-0001인 주문테이블의 주문상태를 업데이트한다
//        //4. OrderStateDto -> 주문상태 테이블에 insert
//
//
//        //1. 성공사례
//        @Test
//        public void 주문취소_성공_테스트 () throws Exception {
//            // 주문 취소시 업데이트 되어야 하는 정보들을 @transactional로 묶었음
//
//            취소테스트환경세팅();
//
//            //1. OrdEtcReqDto -> 주문취소교환반품 테이블에 insert
//            OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "단순변심");
//
//            //2. OrdDetailDto -> 주문번호가 20240503-0001인 주문내역의 주문상태를 업데이트한다
//
//            OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0001",1);
//            ordDetailDto.setOrd_state("취소신청");
//
//            //3. OrderDto -> 주문번호가 20240503-0001인 주문테이블의 주문상태를 업데이트한다
//            OrderDto orderDto = orderDao.select("20240503-0001");
//            orderDto.setOrd_state("취소신청 ");
//
//            //4. OrderStateDto -> 주문상태 테이블에 insert
//            OrderStateDto orderStateDto = new OrderStateDto("20240503-0001", "CNL1");
//
//            assertTrue(ordEtcReqService.insertCancelInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto) == true);
//        }
//
//        //2. 실패사례
//            // 2-2 같은 주문번호의 취소내역이 2개 insert되지 않아야 함(중복 insert 불가)
//            // 2-3  4개의 프로세스에 모두 같은 주문번호가 입력되어야 함
//            // 2.4 not null 컬럼에 null값이 들어갔을 경우
//
//        // 2-1 4개의 프로세스의 주문번호가 모두 일치해야함
////    @Test
//////    @Test(expected = Exception.class)
////        public void  주문취소_롤백_테스트() throws Exception {
////
////            OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0002", "C", "CNS1", "단순변심");
////            OrdDetailDto ordDetailDto = ordDetailDao.selectNumAndSeq("20240503-0002",1);
////            ordDetailDto.setOrd_state("업데이트테스트");
////            OrderDto orderDto = orderDao.select("20240503-0002");
////            orderDto.setOrd_state("취소신청 ");
////            OrderStateDto orderStateDto = new OrderStateDto("20240503-0003","CNL1");
////
////            assertTrue(ordEtcReqService.insertCancelInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto) == true);
////        }
//
//        //주문타입코드 중복에러
//        // 2-2 같은 주문번호의 취소내역이 2개 insert되지 않아야 함(중복 insert 불가)
//        @Test(expected = Exception.class)
//        public void  주문취소_롤백_테스트_주문타입코드_중복에러() throws Exception {
//
//            취소중복에러_테스트환경세팅();
//            OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "단순변심");
//
//            OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0001",1);
//            ordDetailDto.setOrd_state("취소신청");
//
//            OrderDto orderDto = orderDao.select("20240503-0001");
//            orderDto.setOrd_state("취소신청 ");
//
//            OrderStateDto orderStateDto = new OrderStateDto("20240503-0001", "CNL1");
//
////            assertTrue(ordEtcReqService.insertCancelInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto) == true);
//    }
//
//            @Test(expected = DataIntegrityViolationException.class)
//            public void 주문취소_롤백_테스트_not_null_컬럼() throws Exception{
//
//                취소테스트환경세팅();
//                OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "단순변심");
//
//                OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0001",1);
//                ordDetailDto.setOrd_state("취소신청");
//
//                OrderDto orderDto = orderDao.select("20240503-0001");
//                orderDto.setOrd_state("취소신청 ");
//
//                OrderStateDto orderStateDto = new OrderStateDto("20240503-0001", null);
//
//                assertTrue(ordEtcReqService.insertCancelInfo(session, ordEtcReqDto, ordDetailDto, orderDto, orderStateDto) == true);
//            }
//
//            //주문반품 테스트
//            /*
//            1. 테스트 환경 셋팅 테스트는 공통으로 사용해도 되는지 체크
//            2. 주문반품성공테스트
//            3. 주문반품실패테스트
//                a. 타입코드 중복 X 보류
//                 --> 쿼리문을 수정할지 서비스에 유효성검증을 추가할지 고민
//                b. not null 컬럼에 null 값
//
//                d. 없는 주문번호의 배송내역 정보 입력 시 롤백
//            */
//            @Test
//            public void 주문_반품_성공테스트() throws Exception {
//                반품테스트환경세팅();
//
//                //1. OrdEtcReqDto -> 주문취소교환반품 테이블에 insert
//                OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0002", "R", "CNS1", "단순변심");
//
//                //2. OrdDetailDto -> 주문번호가 20240503-0002인 주문내역의 주문상태를 업데이트한다
//
//                OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0002",1);
//                ordDetailDto.setOrd_state("반품신청");
//
//                //3. OrderDto -> 주문번호가 20240503-0002인 주문테이블의 주문상태를 업데이트한다
//                OrderDto orderDto = orderDao.select("20240503-0002");
//                orderDto.setOrd_state("반품신청 ");
//
//                //4. OrderStateDto -> 주문상태 테이블에 insert
//                OrderStateDto orderStateDto = new OrderStateDto("20240503-0002", "RTN1");
//
//                //5. DvlDto -> 배송테이블에 insert
//                DeliveryDto deliveryDto = new DeliveryDto("20240503-0002", "Y", "홍유경", "01012341234", "11111", "서울시 송파구", "정석아파트 101동 101호");
//
//                assertTrue(ordEtcReqService.insertRefundInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto,deliveryDto) == true);
//            }
//
//    //b. not null 컬럼에 null 값
//    @Test(expected = DataIntegrityViolationException.class)
////    @Test
//    public void 주문반품_롤백_테스트_not_null_컬럼() throws Exception{
//
//        반품테스트환경세팅();
//        OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0002", "R", "CNS1", "단순변심");
//
//        OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0002",1);
//        ordDetailDto.setOrd_state("반품신청");
//
//        OrderDto orderDto = orderDao.select("20240503-0002");
//        orderDto.setOrd_state("반품신청 ");
//
//        OrderStateDto orderStateDto = new OrderStateDto("20240503-0002", null);
//
//        DeliveryDto dlvDto = new DeliveryDto("20240503-0002", "Y", "홍유경", "01012341234", "11111", "서울시 송파구", "정석아파트 101동 101호");
//
//        assertTrue(ordEtcReqService.insertRefundInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto, dlvDto) == true);
//    }
//
//   // d. 없는 주문번호의 배송내역 정보 입력 시 롤백
//    @Test(expected = DataIntegrityViolationException.class)
//    public void 주문반품_롤백_테스트_잘못된주문번호() throws Exception{
//
//        반품테스트환경세팅();
//        OrdEtcReqDto ordEtcReqDto = new OrdEtcReqDto("20240503-0002", "R", "CNS1", "단순변심");
//
//        OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0002",1);
//        ordDetailDto.setOrd_state("반품신청");
//
//        OrderDto orderDto = orderDao.select("20240503-0002");
//        orderDto.setOrd_state("반품신청");
//
//        OrderStateDto orderStateDto = new OrderStateDto("20240503-0002", "RTN1");
//
//        DeliveryDto dlvDto = new DeliveryDto("20240503-5555", "Y", "홍유경", "01012341234", "11111", "서울시 송파구", "정석아파트 101동 101호");
//
//        assertTrue(ordEtcReqService.insertRefundInfo(ordEtcReqDto, ordDetailDto, orderDto, orderStateDto, dlvDto) == true);
//
//    }
//
//
//    /*
//    주문교환 테스트
//    1. 주문교환 환경세팅
//    2. 주문교환성공테스트
//        주문옵션 변경 이후 저장한 값으로 주문교환테이블에 insert잘 되는 것 까지 포함해야함
//        --> 주문옵션은 2가지 중 한가지라도 변경된 사항이 없을 경우 모달창에서 걸러줘야함
//        모달창에서 선택한 옵션과 상품정보의 옵션과 비교를 하는데
//        opt1과 opt2가 모두 같으면 경고창!
//
//
//    */
//
//            //보조메서드
//            public void cleanStateDB() throws Exception {
//                orderStateDao.deleteAll();
//            }
//
//            public void cleanEtcDB(){
//                ordEtcReqDao.deleteAll();
//        }
//
//            public void initOrdDetail() throws Exception {
//                OrderDetailDto orderDetailDto = orderDetailDao.selectNumAndSeq("20240503-0001",1);
//                orderDetailDto.setOrd_state("주문완료");
//                orderDetailDao.updateOrdState(orderDetailDto);
//            }
//
//            public void initOrder() throws Exception {
//                OrderDto orderDto = orderDao.select("20240503-0001");
//                orderDto.setOrd_state("주문완료 ");
//                orderDao.updateStateCode(orderDto);
//            }
//
//            public void initOrdDetailForRefundTest() throws Exception {
//                OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0002",1);
//                OrderDetailDto ordDetailDto1 = orderDetailDao.selectNumAndSeq("20240503-0002",2);
//                ordDetailDto.setOrd_state("배송완료");
//                ordDetailDto.setOpt1("black");
//                ordDetailDto.setOpt2("S");
//                ordDetailDto1.setOrd_state("배송완료");
//                ordDetailDto1.setOpt1("black");
//                ordDetailDto1.setOpt2("S");
//                orderDetailDao.updateOrdState(ordDetailDto);
//                orderDetailDao.updateOption(ordDetailDto);
//                orderDetailDao.updateOrdState(ordDetailDto1);
//                orderDetailDao.updateOption(ordDetailDto1);
//            }
//
//            public void initOrderForRefundTest() throws Exception {
//                OrderDto orderDto = orderDao.select("20240503-0002");
//                orderDto.setOrd_state("배송완료 ");
//                orderDao.updateStateCode(orderDto);
//            }
    }