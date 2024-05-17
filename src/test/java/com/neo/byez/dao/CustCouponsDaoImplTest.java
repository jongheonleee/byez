package com.neo.byez.dao;

import com.neo.byez.domain.CouponDto;
import com.neo.byez.domain.CustCouponsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CustCouponsDaoImplTest {

    @Autowired
    CouponDaoImpl couponDao;
    @Autowired
    CustCouponsDaoImpl custCouponsDao;

    @Test
    public void test() throws Exception {
        System.out.println(custCouponsDao);
    }
    @Test
    public void count() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 쿠폰 지급
        assertTrue(custCouponsDao.insert("userId", "aaa") == 1);

        // 4. 개수 확인
        assertTrue(custCouponsDao.count() == 1);

    }

    @Test
    public void select() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 두명의 고객에게 쿠폰 지급

        custCouponsDao.insert("userId1", "aaa");
        custCouponsDao.insert("userId2", "aaa");

        assertTrue(custCouponsDao.count() == 2);

        // 4. 특정 고객의 쿠폰이 잘 가져와지는지 확인

        List<CustCouponsDto> cust1Coupons = custCouponsDao.select("userId1");

        assertTrue(cust1Coupons.size() == 1);
        assertTrue(cust1Coupons.get(0).getId().equals("userId1"));

    }

    @Test
    public void selectAll() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 여러 고객들에게 쿠폰 지급
        assertTrue(custCouponsDao.insert("user1", "aaa") == 1);
        assertTrue(custCouponsDao.insert("user2", "aaa") == 1);

        assertTrue(custCouponsDao.count() == 2);

        // 4. 조회결과 개수와 쿠폰 추가 개수와 일치하는지 확인
        List<CustCouponsDto> allCoupons = custCouponsDao.selectAll();

        assertTrue(allCoupons.size() == custCouponsDao.count());

    }

    @Test
    public void insert() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 쿠폰 지급
        custCouponsDao.insert("user1", "aaa");

        // 4. 쿠폰 조회
        List<CustCouponsDto> userCoupons = custCouponsDao.select("user1");

        // 고객이 가진 쿠폰의 개수가 1인지 확인 & 유저id가 맞게 들어갔는지 확인
        assertTrue(userCoupons.size() == 1);
        assertTrue(userCoupons.get(0).getId().equals("user1"));

        // 지급한 쿠폰의 seq값 얻어옴
        CouponDto selectedCoupon = couponDao.selectByName("aaa");
        int selectedCouponSeq = selectedCoupon.getSeq();

        // 지급한 쿠폰과 고객이 가진 쿠폰의 seq값이 동일한지 체크
        assertTrue(userCoupons.get(0).getCouponSeq() == selectedCouponSeq);


    }

    @Test
    public void deleteAll() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);
        
        // 3. 고객들에게 여러개 쿠폰 지급
        final int ISSUE_COUPON_NUM1 = 50;
        final int ISSUE_COUPON_NUM2 = 30;

        for(int i=0; i<ISSUE_COUPON_NUM1; i++) {
            custCouponsDao.insert("user1", "aaa");
        }
        for (int i=0; i<ISSUE_COUPON_NUM2; i++) {
            custCouponsDao.insert("user2", "aaa");
        }
        
        // 4. 지급되었는지 확인
        List<CustCouponsDto> user1Coupons = custCouponsDao.select("user1");
        List<CustCouponsDto> user2Coupons = custCouponsDao.select("user2");

        assertTrue(user1Coupons.size() == ISSUE_COUPON_NUM1);
        assertTrue(user2Coupons.size() == ISSUE_COUPON_NUM2);


        // 5. 고객들의 쿠폰 전부 삭제
        custCouponsDao.deleteAll();
        
        // 6. 삭제되었는지 확인
        user1Coupons = custCouponsDao.select("user1");
        user2Coupons = custCouponsDao.select("user2");

        assertTrue(user1Coupons.size() == 0);
        assertTrue(user2Coupons.size() == 0);

    }

    @Test
    public void delete() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 여러 고객들에게 쿠폰 지급

        assertTrue(custCouponsDao.insert("user1", "aaa") == 1);
        assertTrue(custCouponsDao.insert("user2", "aaa") == 1);

        assertTrue(custCouponsDao.count() == 2);

        // 4. 특정쿠폰 제거
        List<CustCouponsDto> user1Coupons = custCouponsDao.select("user1");

        assertTrue(custCouponsDao.delete(user1Coupons.get(0).getSeq()) == 1);

        // 5. 제거되었는지 확인
        assertTrue(custCouponsDao.count() == 1);

        user1Coupons = custCouponsDao.select("user1");
        assertTrue(user1Coupons.size() == 0);

    }

    @Test
    public void update() throws Exception {
        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 쿠폰 지급
        custCouponsDao.insert("user1", "aaa");

        assertTrue(custCouponsDao.count() == 1);

        // 4. 쿠폰 조회
        List<CustCouponsDto> userCoupons = custCouponsDao.select("user1");

        //  5. 쿠폰 사용 처리
        int seq = userCoupons.get(0).getSeq();

        assertTrue(custCouponsDao.update(seq) == 1);

        // 6. 쿠폰 조회
        userCoupons = custCouponsDao.select("user1");

        // 사용한 쿠폰은 조회되지 않아야 함
        assertTrue(custCouponsDao.count() == 1);
        assertTrue(userCoupons.size() == 0);
    }

    @Test
    public void bulkInsert() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 여러고객에게 대량의 쿠폰 지급
        final int ISSUE_COUPON_NUM1 = 100;
        final int ISSUE_COUPON_NUM2 = 150;

        for(int i=0; i<ISSUE_COUPON_NUM1; i++) {
            custCouponsDao.insert("user1Id", "aaa");
        }

        for(int i=0; i<ISSUE_COUPON_NUM2; i++) {
            custCouponsDao.insert("user2Id", "bbb");
        }

        assertTrue(custCouponsDao.count() == ISSUE_COUPON_NUM1 + ISSUE_COUPON_NUM2);

        // 4. 쿠폰 지급됐는지 확인
        List<CustCouponsDto> user1Coupons = custCouponsDao.select("user1Id");
        List<CustCouponsDto> user2Coupons = custCouponsDao.select("user2Id");

        // 고객 보유 쿠폰 수와 지급 쿠폰수가 동일한지 확인
        assertTrue(user1Coupons.size() == ISSUE_COUPON_NUM1);
        assertTrue(user2Coupons.size() == ISSUE_COUPON_NUM2);

    }

    @Test
    public void insertNonExistingCoupon() throws Exception {

        // 1. 쿠폰 테이블 초기화 및 검증
        initCouponTable(); // aaa, bbb 이름을 가진 쿠폰 생성

        // 2. 보유 쿠폰 테이블 전부 삭제 및 검증
        custCouponsDao.deleteAll();
        assertTrue(custCouponsDao.count() == 0);

        // 3. 없는 쿠폰 추가 실패 확인
        assertTrue(custCouponsDao.insert("userId", "ccc") == 0);
        assertTrue(custCouponsDao.count() == 0);
    }


    private void insertCoupon(String couponName) throws Exception {
        CouponDto couponDto = new CouponDto(couponName, 30, 30, 50000, 50000, "PER");
        couponDao.insert(couponDto);

        CouponDto coupon = couponDao.selectByName(couponName);
        assertTrue(coupon.getName().equals(couponName));
    }

    private void initCouponTable() throws Exception {
        couponDao.deleteAll();

        CouponDto couponDto1 = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponDao.insert(couponDto1);
        couponDao.insert(couponDto2);

        CouponDto coupon1 = couponDao.selectByName("aaa");
        CouponDto coupon2 = couponDao.selectByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponDao.count() == 2);
    }
}