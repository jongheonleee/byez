package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.domain.order.OrderDetailJoinItemDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDetailDaoImplTest {
    @Autowired
    OrderDetailDaoImpl orderDetailDao;

    @Test
    public void 초기화테스트() throws Exception {
        // assert = 빈 등록
        assertTrue(orderDetailDao != null);

        // assert = 테이블 전체 삭제
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);
    }

    @Test
    public void test() throws Exception {
        System.out.println(orderDetailDao.select("aaa"));
        System.out.println(orderDetailDao.select("aaa").size());
    }

    @Test
    public void 데이터삽입테스트_1개() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given, when = 객체 1개 생성
        OrderDetailDto dto = makeOrderDetailDto(0);

        // assert = 정상 삽입
        assertTrue(orderDetailDao.insert(dto) == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception {
        // 테이블초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i + 1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        for (int i = 0; i < 1000; i++) {
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i + 1);
        }
    }

    @Test
    public void 조회테스트_1개() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given = 테스트 데이터 100개 삽입
        for (int i = 0; i < 100; i++) {
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i + 1);
        }
        // 비교 기준
        String testOrd_num1 = makeOrderDetailDto(0).getOrd_num();

        // 비교 대상 - DB데이터
        String testOrd_num2 = orderDetailDao.select(testOrd_num1).get(0).getOrd_num();

        // assert = 원하는 값을 조회
        assertTrue(testOrd_num1.equals(testOrd_num2));
    }

    @Test
    public void 삭제테스트_1개() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given = 원본데이터 1개 삽입
        OrderDetailDto dto = makeOrderDetailDto(0);
        String ord_num = dto.getOrd_num();
        assertTrue(orderDetailDao.insert(dto) == 1);
        assertTrue(orderDetailDao.countAll() == 1);

        // do = 데이터 1개 삭제
        orderDetailDao.delete(ord_num);

        // assert = 정상적으로 삭제
        assertTrue(orderDetailDao.countAll() == 0);
    }

    @Test
    public void 삭제테스트_전체() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given = 데이터 1000개 삽입
        for (int i = 0; i < 1000; i++) {
            // given, when = 객체 1000개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i + 1);
        }
        assertTrue(orderDetailDao.countAll() == 1000);

        // do = 테이블 전체 삭제
        orderDetailDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(orderDetailDao.countAll() == 0);
    }


    public OrderDetailDto makeOrderDetailDto(int num) {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setOrd_num("TestOrd_num" + num);
        dto.setSeq(num);
        dto.setItem_num("" + num);
        dto.setId("TestID" + num);
        dto.setItem_name("TestItem" + num);
        dto.setPrice(10000 + num);
        dto.setItem_qty(num % 5 == 0 ? 1 : num % 5);
        dto.setItem_price(10000 + num);
        dto.setOrd_date("20240429");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }


    //유경추가
    //취소반품교환내역 select
//    @Test
//    public void selectAllEtc() throws Exception{
//        List<OrderDetailDto> list = orderDetailDao.selectAll("aaa");
//        List<OrderDetailDto> list1 = orderDetailDao.selectAllEtc("aaa");
//        assertTrue(list.size() != list1.size());
//    }
//    @Test
//    public void updateOption() throws Exception {
//
//        cleanDB();
//        assertTrue(orderDetailDao.getCount() == 0);
//        insertData(1);
//
//        //1. 데이터 1개 수정 후 업데이트된 값확인
//        OrderDetailDto ordDetailDto = orderDetailDao.selectByOrdNum("20240503-0001").get(0);
//        ordDetailDto.setOpt1("white");
//        ordDetailDto.setOpt2("small");
//
//        orderDetailDao.updateOption(ordDetailDto);
//
//        assertTrue(ordDetailDto.getOpt1() == "white");
//        assertTrue(ordDetailDto.getOpt2() == "small");
//
//        //2. 옵션 2가지 중 1가지만 업뎃 가능여부 확인
//
//        OrderDetailDto ordDetailDto1 = orderDetailDao.selectByOrdNum("20240503-0001").get(0);
//        ordDetailDto1.setOpt1("blue");
//        ordDetailDto1.setOpt2("small");
//
//        orderDetailDao.updateOption(ordDetailDto1);
//        assertTrue(ordDetailDto1.getOpt1() == "blue");
//        assertTrue(ordDetailDto1.getOpt2() == "small");
//
//
//        //3. 옵션 2가지 중 업데이트 된 사항이 없으면 예외발생 테스트
//        // 둘중 한가지라도 변경이 되었어야 update 진행하는 부분은 service 단에서 처리
//        OrderDetailDto ordDetailDto2 = orderDetailDao.selectByOrdNum("20240503-0001").get(0);
//        ordDetailDto2.setOpt1("blue");
//        ordDetailDto2.setOpt2("small");
//
//        orderDetailDao.updateOption(ordDetailDto2);
//        assertTrue(ordDetailDto2.getOpt1() == "blue");
//        assertTrue(ordDetailDto2.getOpt2() == "small");
//        System.out.println(ordDetailDto2.getOpt1());
//        System.out.println(ordDetailDto2.getOpt2());
//
//    }

    //1. 존재하는 값 select
    //2. 존재하지않는 seq select 시 예외처리
    //3. 존재하지않는 주문번호 select 시 예외처리
    @Test(expected = NullPointerException.class)
//    @Test
    public void selectNumAndSeq() throws Exception {
        //1. 존재하는 값 select
        OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0001", 2);
        assertTrue(ordDetailDto.getSeq() == 2);

        //2. 존재하지않는 seq select 시 예외처리(nullPointException)
        OrderDetailDto ordDetailDto1 = orderDetailDao.selectNumAndSeq("20240503-0001", 11);
        assertTrue(ordDetailDto1.getSeq() == 11);
        System.out.println(ordDetailDto1.getSeq());

        //3. 존재하지않는 주문번호 select 시 예외처리
        OrderDetailDto ordDetailDto2 = orderDetailDao.selectNumAndSeq("20240503-0002", 1);
        assertTrue(ordDetailDto2.getSeq() == 1);
        assertTrue(ordDetailDto2.getOrd_num() == "20240503-0002");
    }

//    @Test
//    public void updateOrdState() throws  Exception{
//        List<OrderDetailDto> list = orderDetailDao.selectByOrdNum("20240503-0001");
//        System.out.println(list.size());
//        list.get(0).setOrd_state("반품완료");
//        int rowCnt = orderDetailDao.updateOrdState(list.get(0));
//        assertTrue(rowCnt == 1);
////        assertTrue(ordDetailDao.selectNumAndSeq("20240503-0001", 1).getOrd_state() == "배송완료");
//        assertTrue(list.get(0).getOrd_state()=="반품완료");
//    }
    //-->mapper의 쿼리문이 주석처리되어 있어서 주석처리함


    //1. 존재하는 주문번호&시퀀스로 조회한 객체의 주문상태를 변경했을 경우
    //2. 존재하지 않는 주문번호&시퀀스로 조회하고 주문상태 변경 시도하는 경우
    @Test(expected = NullPointerException.class)
    public void updateEachOrdState() throws Exception {

        //1. 존재하는 주문번호&시퀀스로 조회한 객체의 주문상태를 변경했을 경우
        OrderDetailDto ordDetailDto = orderDetailDao.selectNumAndSeq("20240503-0002", 1);
        ordDetailDto.setOrd_state("교환신청");
        int rowCnt = orderDetailDao.updateEachOrdState(ordDetailDto);
        assertTrue(rowCnt == 1);

        //2. 존재하지 않는 주문번호&시퀀스로 조회하고 주문상태 변경 시도하는 경우
        //--> NullPointerException
        OrderDetailDto ordDetailDto1 = orderDetailDao.selectNumAndSeq("20240503-0002", 10);
        ordDetailDto1.setOrd_state("교환신청");
        int rowCnt1 = orderDetailDao.updateEachOrdState(ordDetailDto1);
        assertTrue(rowCnt1 == 0);
    }

    // 2. 보조메서드
    public void cleanDB() throws Exception {
        orderDetailDao.deleteAll();
    }

    public void insertData(int size) throws Exception {
        for (int i = 0; i < size; i++) {
            OrderDetailDto expectedDto = new OrderDetailDto("20240503-0001", "1001", "aaa", "스퀘어넥 골지 반팔니트", 29900, 1, 29900, "black", "free", "주문완료");
            orderDetailDao.insert(expectedDto);
        }
    }

//-------------------------------찬빈추가
@Test
// 이 메서드는 원래 사용자이름으로 가져오며 ord_state가 "구매확정"인 값을 가져오는 기능이다.
// 추후에 ord_state가 어떻게 될지 논의 후 해당 메소드 mapper sql에 where절에 ord_state 을 추가할 것
public void 리뷰안한사용자리뷰값주기() throws Exception {
    // 테이블 초기화
    orderDetailDao.deleteAll();
    assertTrue(orderDetailDao.countAll() == 0);

    // given = 테스트 데이터 100개 삽입
    for (int i = 0; i < 10; i++) {
        // given, when = 객체 100개 생성
        OrderDetailDto dto = makeOrderDetailDto(i);

        // do
        orderDetailDao.insert(dto);

        // assert = 정상 삽입
        assertTrue(orderDetailDao.countAll() == i + 1);
    }

//        List<OrderDetailJoinItemDto> list = orderDetailDao.selectById("TestID0");
//      assertTrue(list.get(0).getId().equals("TestID0"));

}
    @Test
// 이 메서드는 리뷰작성시 상품번호 사용자 주문번호로 리뷰를 정확한 곳에 쓰일 수 있도록 하는 메서드이다.
    public void 값찾기_주문상품아이디() throws Exception {
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given = 테스트 데이터 100개 삽입
        for (int i = 0; i < 10; i++) {
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i + 1);
        }

//        OrderDetailDto list  =  orderDetailDao.selectOrdItem("TestOrd_num0","0","TestID0");
//        assertTrue(list.getId().equals("TestID0"));
//        assertTrue(list.getOrd_num().equals("TestOrd_num0"));
//        assertTrue(list.getItem_num().equals("0"));

    }
    @Test
    public void 리뷰작성_업데이트() throws Exception {

    }
}