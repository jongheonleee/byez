package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrdEtcReqDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdEtcReqDaoImplTest {

    @Autowired
    OrdEtcReqDaoImpl ordEtcReqDao;
    @Autowired
    OrderDetailDaoImpl orderDetailDao;

    @Test
    public void test(){
        assertTrue(ordEtcReqDao !=null);
        assertTrue(orderDetailDao != null);
    }

    //countTest
    //1. 삽입 후 카운트
    //1-1 1개 삽입
    //1-2 10개 삽입
    //1-3 100개 삽입

    //2. 전체 삭제 후 카운트
    @Test
    public void getCount() throws Exception {
        cleanDB();
        assertTrue(ordEtcReqDao.getCount() == 0);

        OrdEtcReqDto expectedDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "고객변심");
        ordEtcReqDao.insertCancel(expectedDto);
        int rowCnt1 = ordEtcReqDao.getCount();
        assertTrue(ordEtcReqDao.getCount() == 1);
    }

    @Test
    public void insertCancel() throws Exception {
        //1개의 주문 상품 삽입 후 선택
            cleanDB();

            OrdEtcReqDto expectedDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "고객변심");
            int rowCnt = ordEtcReqDao.insertCancel(expectedDto);
            assertTrue(rowCnt == 1);

        //주문 취소는 한 주문당 1회만 가능
        // 주문번호가 같아도 seq로 인해 중복 insert되는 점 확인
        //트리거를 통해 주문코드가 "C"인 경우 seq가 증가되지 않도록 처리함
    }

    //주문취소시 seq가 증가되지 않는 예외 확인 테스트
//        @Test(expected = DataAccessException.class)
//        public void insertCancelShouldFailForTypeC() {
//            OrdEtcReqDto expectedDto = new OrdEtcReqDto("20240503-0001", "C", "CNS1", "고객변심");
//            ordEtcReqDao.insertCancel(expectedDto);
//        }

    @Test
    public void deleteAll() throws Exception {
        cleanDB();
        int rowCnt = ordEtcReqDao.getCount();
        assertTrue(rowCnt == 0);
    }

    // 2. 보조메서드
    public void cleanDB() throws Exception {
        ordEtcReqDao.deleteAll();
    }
}