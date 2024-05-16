package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderDetailDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDetailDaoImplTest {
    @Autowired
    OrderDetailDaoImpl orderDetailDao;

    @Test
    public void 초기화테스트() throws Exception{
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
    public void 데이터삽입테스트_1개() throws Exception{
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        // given, when = 객체 1개 생성
        OrderDetailDto dto = makeOrderDetailDto(0);

        // assert = 정상 삽입
        assertTrue(orderDetailDao.insert(dto) == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception{
        // 테이블초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i+1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception{
        // 테이블 초기화
        orderDetailDao.deleteAll();
        assertTrue(orderDetailDao.countAll() == 0);

        for(int i=0; i < 1000; i++){
            // given, when = 객체 100개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);

            // do
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i+1);
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
        for(int i=0; i < 1000; i++){
            // given, when = 객체 1000개 생성
            OrderDetailDto dto = makeOrderDetailDto(i);
            orderDetailDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderDetailDao.countAll() == i+1);
        }
        assertTrue(orderDetailDao.countAll() == 1000);

        // do = 테이블 전체 삭제
        orderDetailDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(orderDetailDao.countAll() == 0);
    }



    public OrderDetailDto makeOrderDetailDto(int num){
        OrderDetailDto dto = new OrderDetailDto();
        dto.setOrd_num("TestOrd_num" + num);
        dto.setSeq(num);
        dto.setItem_num(num);
        dto.setId("TestID" + num);
        dto.setItem_name("TestItem" + num);
        dto.setPrice(10000 + num);
        dto.setItem_qty(num%5 == 0 ? 1:num%5);
        dto.setItem_price(10000 + num);
        dto.setOrd_date("20240429");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }

}