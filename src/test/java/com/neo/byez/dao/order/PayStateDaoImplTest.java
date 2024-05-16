package com.neo.byez.dao.order;

import com.neo.byez.domain.order.PayStateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PayStateDaoImplTest {
    @Autowired
    PayStateDaoImpl payStateDao;

    @Test
    public void 초기화테스트() throws Exception{
        // assert = payStateDao 빈 등록
        assertTrue(payStateDao != null);

        // assert = 테이블 전체 삭제
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);
    }

    @Test
    public void 데이터삽입테스트_1개() throws Exception{
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        // given, when = 객체 1개 생성
        PayStateDto dto = makePayStateDto(0);

        // do
        payStateDao.insert(dto);

        // assert = 정상 삽입
        assertTrue(payStateDao.count() == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception{
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            PayStateDto dto = makePayStateDto(i);

            // do
            payStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payStateDao.count() == i+1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception{
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        for(int i=0; i < 1000; i++){
            // given, when = 객체 100개 생성
            PayStateDto dto = makePayStateDto(i);

            // do
            payStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payStateDao.count() == i+1);
        }
    }

    @Test
    public void 조회테스트_1개() throws Exception{
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        // given = 테스트 데이터 100개 삽입
        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            PayStateDto dto = makePayStateDto(i);

            // do
            payStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payStateDao.count() == i+1);
        }

        // 비교 기준
        String testPay_num1 = makePayStateDto(0).getPay_num();

        // 비교 대상 - DB데이터
        String testPay_num2 = payStateDao.select(testPay_num1).get(0).getPay_num();

        // assert = 원하는 값을 조회
        assertTrue(testPay_num1.equals(testPay_num2));
    }

    @Test
    public void 업데이트테스트_1개() throws Exception {
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        // given = 원본데이터 1개 삽입
        PayStateDto dto = makePayStateDto(0);

        // 비교 기준 데이터
        String pay_num = dto.getPay_num();
        String ord_state = dto.getState_code();
        String up_date = dto.getUp_date();
        String up_id = dto.getUp_id();

        // 데이터 삽입
        payStateDao.insert(dto);
        assertTrue(payStateDao.count() == 1);
        assertTrue(pay_num.equals(payStateDao.select(pay_num).get(0).getPay_num()));

        // do = 업데이트

        // 업데이트용 데이터
        String ord_state_dummy = "결제취소";
        String up_id_dummy = "abcd";

        dto.setState_code(ord_state_dummy);
        dto.setUp_id(up_id_dummy);
        payStateDao.update(dto);

        // DB 비교대상
        PayStateDto dto_target = payStateDao.select(pay_num).get(0);

        // assert = 원본과 대상 비교

        // 원본과 대상의 키 동일
        assertTrue(dto.getPay_num().equals(dto_target.getPay_num()));
        // 대상의 주문상태 업데이트 성공
        assertTrue(dto_target.getState_code().equals(ord_state_dummy));
        // 대상의 up_date 업데이트 성공
        assertTrue(!dto_target.getUp_date().equals(up_date));
        // 대상의 up_id 업데이트 성공
        assertTrue(dto_target.getUp_id().equals(up_id_dummy));
    }

    @Test
    public void 삭제테스트_1개() throws Exception {
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        // given = 원본데이터 1개 삽입
        PayStateDto dto = makePayStateDto(0);
        String pay_num = dto.getPay_num();
        assertTrue(payStateDao.insert(dto) == 1);
        assertTrue(payStateDao.count() == 1);

        // do = 데이터 1개 삭제
        payStateDao.delete(pay_num);

        // assert = 정상적으로 삭제
        assertTrue(payStateDao.count() == 0);
    }

    @Test
    public void 삭제테스트_전체() throws Exception {
        // 테이블 초기화
        payStateDao.deleteAll();
        assertTrue(payStateDao.count() == 0);

        // given = 데이터 1000개 삽입
        for(int i=0; i < 1000; i++){
            // given, when = 객체 1000개 생성
            PayStateDto dto = makePayStateDto(i);
            payStateDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(payStateDao.count() == i+1);
        }
        assertTrue(payStateDao.count() == 1000);

        // do = 테이블 전체 삭제
        payStateDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(payStateDao.count() == 0);
    }



    public PayStateDto makePayStateDto(int num){
        PayStateDto dto = new PayStateDto();
        dto.setPay_num("TestPay_num" + num);
        dto.setSeq(num);
        dto.setState_code("결제완료");
        dto.setState_chg_date("20240505");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }

}