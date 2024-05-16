package com.neo.byez.dao.order;

import com.neo.byez.domain.order.PayDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PayDaoImplTest {
    @Autowired
    PayDaoImpl payDao;

    @Test
    public void 초기화테스트() throws Exception{
        // assert = payDao 빈 등록
        assertTrue(payDao != null);

        // assert = 테이블 전체 삭제
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);
    }

    @Test
    public void 데이터삽입테스트_1개() throws Exception{
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        // given, when = 객체 1개 생성
        PayDto dto = makePayDto(0);

        // do
        payDao.insert(dto);

        // assert = 정상 삽입
        assertTrue(payDao.count() == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception{
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            PayDto dto = makePayDto(i);

            // do
            payDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payDao.count() == i+1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception{
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        for(int i=0; i < 1000; i++){
            // given, when = 객체 100개 생성
            PayDto dto = makePayDto(i);

            // do
            payDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payDao.count() == i+1);
        }
    }

    @Test
    public void 조회테스트_1개() throws Exception{
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        // given = 테스트 데이터 100개 삽입
        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            PayDto dto = makePayDto(i);

            // do
            payDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payDao.count() == i+1);
        }

        // 비교 기준
        String testPay_num1 = makePayDto(0).getPay_num();

        // 비교 대상 - DB데이터
        String testPay_num2 = payDao.select(testPay_num1).getPay_num();

        // assert = 원하는 값을 조회
        assertTrue(testPay_num1.equals(testPay_num2));
    }

    @Test
    public void 업데이트테스트_1개() throws Exception {
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        // given = 원본데이터 1개 삽입
        PayDto dto = makePayDto(0);

        // 비교 기준 데이터
        String pay_num = dto.getPay_num();
        String ord_state = dto.getState();
        String up_date = dto.getUp_date();
        String up_id = dto.getUp_id();

        // 데이터 삽입
        payDao.insert(dto);
        assertTrue(payDao.count() == 1);
        assertTrue(pay_num.equals(payDao.select(pay_num).getPay_num()));

        // do = 업데이트

        // 업데이트용 데이터
        String ord_state_dummy = "결제취소";
        String up_id_dummy = "abcd";

        dto.setState(ord_state_dummy);
        dto.setUp_id(up_id_dummy);
        payDao.update(dto);

        // DB 비교대상
        PayDto dto_target = payDao.select(pay_num);

        // assert = 원본과 대상 비교

        // 원본과 대상의 키 동일
        assertTrue(dto.getPay_num().equals(dto_target.getPay_num()));
        // 대상의 주문상태 업데이트 성공
        assertTrue(dto_target.getState().equals(ord_state_dummy));
        // 대상의 up_date 업데이트 성공
        assertTrue(!dto_target.getUp_date().equals(up_date));
        // 대상의 up_id 업데이트 성공
        assertTrue(dto_target.getUp_id().equals(up_id_dummy));
    }

    @Test
    public void 삭제테스트_1개() throws Exception {
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        // given = 원본데이터 1개 삽입
        PayDto dto = makePayDto(0);
        String pay_num = dto.getPay_num();
        assertTrue(payDao.insert(dto) == 1);
        assertTrue(payDao.count() == 1);

        // do = 데이터 1개 삭제
        payDao.delete(pay_num);

        // assert = 정상적으로 삭제
        assertTrue(payDao.count() == 0);
    }

    @Test
    public void 삭제테스트_전체() throws Exception {
        // 테이블 초기화
        payDao.deleteAll();
        assertTrue(payDao.count() == 0);

        // given = 데이터 1000개 삽입
        for(int i=0; i < 1000; i++){
            // given, when = 객체 1000개 생성
            PayDto dto = makePayDto(i);
            payDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payDao.count() == i+1);
        }
        assertTrue(payDao.count() == 1000);

        // do = 테이블 전체 삭제
        payDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(payDao.count() == 0);
    }



    public PayDto makePayDto(int num){
        PayDto dto = new PayDto();
        dto.setPay_num("TestPay_num" + num);
        dto.setOrd_num("TestOrd_num" + num);
        dto.setPrice(10000 + num);
        dto.setMtd_code("PMT03");
        dto.setPay_date("20240429");
        dto.setState("결제완료");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }

}