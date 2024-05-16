package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderStateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderStateDaoImplTest {
    @Autowired
    OrderStateDaoImpl orderStateDao;

    @Test
    public void 초기화테스트() throws Exception{
        // assert = 빈 등록
        assertTrue(orderStateDao != null);

        // assert = 테이블 전체 삭제
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);
    }

    @Test
    public void 데이터삽입테스트_1개() throws Exception{
        // 테이블 초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        // given, when = 객체 1개 생성
        OrderStateDto dto = makeOrderStateDto(0);

        // assert = 정상 삽입
        assertTrue(orderStateDao.insert(dto) == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception{
        // 테이블초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            OrderStateDto dto = makeOrderStateDto(i);

            // do
            orderStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderStateDao.countAll() == i+1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception{
        // 테이블 초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        for(int i=0; i < 1000; i++){
            // given, when = 객체 100개 생성
            OrderStateDto dto = makeOrderStateDto(i);

            // do
            orderStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderStateDao.countAll() == i+1);
        }
    }

    @Test
    public void 조회테스트_1개() throws Exception {
        // 테이블 초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        // given = 테스트 데이터 100개 삽입
        for (int i = 0; i < 100; i++) {
            // given, when = 객체 100개 생성
            OrderStateDto dto = makeOrderStateDto(i);

            // do
            orderStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderStateDao.countAll() == i + 1);
        }
        // 비교 기준
        String testOrd_num1 = makeOrderStateDto(0).getOrd_num();

        // 비교 대상 - DB데이터
        String testOrd_num2 = orderStateDao.select(testOrd_num1).get(0).getOrd_num();

        // assert = 원하는 값을 조회
        assertTrue(testOrd_num1.equals(testOrd_num2));
    }

    @Test
    public void 삭제테스트_1개() throws Exception {
        // 테이블 초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        // given = 원본데이터 1개 삽입
        OrderStateDto dto = makeOrderStateDto(0);
        String ord_num = dto.getOrd_num();
        assertTrue(orderStateDao.insert(dto) == 1);
        assertTrue(orderStateDao.countAll() == 1);

        // do = 데이터 1개 삭제
        orderStateDao.delete(ord_num);

        // assert = 정상적으로 삭제
        assertTrue(orderStateDao.countAll() == 0);
    }

    @Test
    public void 삭제테스트_전체() throws Exception {
        // 테이블 초기화
        orderStateDao.deleteAll();
        assertTrue(orderStateDao.countAll() == 0);

        // given = 데이터 1000개 삽입
        for(int i=0; i < 1000; i++){
            // given, when = 객체 1000개 생성
            OrderStateDto dto = makeOrderStateDto(i);
            orderStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(orderStateDao.countAll() == i+1);
        }
        assertTrue(orderStateDao.countAll() == 1000);

        // do = 테이블 전체 삭제
        orderStateDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(orderStateDao.countAll() == 0);
    }

    public OrderStateDto makeOrderStateDto(int num){
        OrderStateDto dto = new OrderStateDto();
        dto.setOrd_num("TestOrd_num" + num);
        dto.setSeq(num);
        dto.setState_code("주문완료");
        dto.setChg_date("20240505");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }

}