package com.neo.byez.dao.order;

import com.neo.byez.dao.order.DeliveryDaoImpl;
import com.neo.byez.domain.order.DeliveryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DeliveryDaoImplTest {
    @Autowired
    DeliveryDaoImpl deliveryDao;

    @Test
    public void 초기화테스트() throws Exception{
        // assert = deliveryDao 빈 등록
        assertTrue(deliveryDao != null);

        // assert = 테이블 전체 삭제
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);
    }

    @Test
    public void 데이터삽입테스트_1개() throws Exception{
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        // given, when = 객체 1개 생성
        DeliveryDto dto = makeDeliveryDto(0);

        // do
        deliveryDao.insert(dto);

        // assert = 정상 삽입
        assertTrue(deliveryDao.count() == 1);
    }

    @Test
    public void 데이터삽입테스트_100개() throws Exception{
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            DeliveryDto dto = makeDeliveryDto(i);

            // do
            deliveryDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(deliveryDao.count() == i+1);
        }
    }

    @Test
    public void 데이터삽입테스트_1000개() throws Exception{
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        for(int i=0; i < 1000; i++){
            // given, when = 객체 100개 생성
            DeliveryDto dto = makeDeliveryDto(i);

            // do
            deliveryDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(deliveryDao.count() == i+1);
        }
    }

    @Test
    public void 조회테스트_1개() throws Exception{
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        // given = 테스트 데이터 100개 삽입
        for(int i=0; i < 100; i++){
            // given, when = 객체 100개 생성
            DeliveryDto dto = makeDeliveryDto(i);

            // do
            deliveryDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(deliveryDao.count() == i+1);
        }

        // 비교 기준
        String testDlv_num1 = makeDeliveryDto(0).getDlv_num();

        // 비교 대상 - DB데이터
        String testDlv_num2 = deliveryDao.select(testDlv_num1).getDlv_num();

        // assert = 원하는 값을 조회
        assertTrue(testDlv_num1.equals(testDlv_num2));
    }

    @Test
    public void 업데이트테스트_1개() throws Exception {
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        // given = 원본데이터 1개 삽입
        DeliveryDto dto = makeDeliveryDto(0);

        // 비교 기준 데이터
        String dlv_num = dto.getDlv_num();
        String ord_state = dto.getState();
        String up_date = dto.getUp_date();
        String up_id = dto.getUp_id();

        // 데이터 삽입
        deliveryDao.insert(dto);
        assertTrue(deliveryDao.count() == 1);
        assertTrue(dlv_num.equals(deliveryDao.select(dlv_num).getDlv_num()));

        // do = 업데이트

        // 업데이트용 데이터
        String ord_state_dummy = "배송완료";
        String up_id_dummy = "abcd";

        dto.setState(ord_state_dummy);
        dto.setUp_id(up_id_dummy);
        deliveryDao.update(dto);

        // DB 비교대상
        DeliveryDto dto_target = deliveryDao.select(dlv_num);

        // assert = 원본과 대상 비교

        // 원본과 대상의 키 동일
        assertTrue(dto.getDlv_num().equals(dto_target.getDlv_num()));
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
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        // given = 원본데이터 1개 삽입
        DeliveryDto dto = makeDeliveryDto(0);
        String dlv_num = dto.getDlv_num();
        assertTrue(deliveryDao.insert(dto) == 1);
        assertTrue(deliveryDao.count() == 1);

        // do = 데이터 1개 삭제
        deliveryDao.delete(dlv_num);

        // assert = 정상적으로 삭제
        assertTrue(deliveryDao.count() == 0);
    }

    @Test
    public void 삭제테스트_전체() throws Exception {
        // 테이블 초기화
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.count() == 0);

        // given = 데이터 1000개 삽입
        for(int i=0; i < 1000; i++){
            // given, when = 객체 1000개 생성
            DeliveryDto dto = makeDeliveryDto(i);
            deliveryDao.insert(dto);

            // assert = 정상 삽입
            assertTrue(deliveryDao.count() == i+1);
        }
        assertTrue(deliveryDao.count() == 1000);

        // do = 테이블 전체 삭제
        deliveryDao.deleteAll();

        // assert = 정상적으로 삭제
        assertTrue(deliveryDao.count() == 0);
    }



    public DeliveryDto makeDeliveryDto(int num){
        DeliveryDto dto = new DeliveryDto();
        dto.setDlv_num("TestDlv_num" + num);
        dto.setOrd_num("TestOrd_num" + num);
        dto.setPickup_chk("N");
        dto.setRcpr("TestRcpr");
        dto.setRcpr_mobile("010-1234-5678");
        dto.setZpcd("00"+num);
        dto.setMain_addr("서울시 강남구");
        dto.setDetail_addr("미왕빌딩 10층" + num + "강의실");
        dto.setStart_date("20240430");
        dto.setEnd_date("20240505");
        dto.setState("배송준비중");
        dto.setReg_date("20240429");
        dto.setReg_id("TestID");
        dto.setUp_date("20240429");
        dto.setUp_id("TestID");
        return dto;
    }

}