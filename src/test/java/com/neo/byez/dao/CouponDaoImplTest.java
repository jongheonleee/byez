package com.neo.byez.dao;

import com.neo.byez.domain.CouponDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CouponDaoImplTest {

    @Autowired
    CouponDaoImpl couponDao;

    @Test
    public void count() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        assertTrue(couponDao.insert(couponDto) == 1);

        // 3. 개수 확인
        assertTrue(couponDao.count() == 1);
    }

    @Test
    public void selectByName() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 10, 30, 50000, 50000, "PER");
        couponDao.insert(couponDto);

        // 3. 쿠폰 조회
        CouponDto insertedCoupon = couponDao.selectByName("aaa");

        // 4. 추가한 쿠폰정보와 db의 쿠폰정보 비교
        assertTrue(insertedCoupon.equals(couponDto));

    }

    @Test
    public void selectBySeq() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 10, 30, 50000, 50000, "PER");
        couponDao.insert(couponDto);

        // 3. 쿠폰 조회
        List<CouponDto> coupons = couponDao.selectAll();
        int couponSeq = coupons.get(0).getSeq();

        CouponDto insertedCoupon = couponDao.selectBySeq(couponSeq);

        // 4. 추가한 쿠폰정보와 db의 쿠폰정보 비교
        assertTrue(insertedCoupon.equals(couponDto));
    }

    @Test
    public void selectAll() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 여러쿠폰 추가
        CouponDto couponDto1 = new CouponDto("aaa", 10, 30, 50000, 100000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 20, 60, 10000, 50000, "PER");
        CouponDto couponDto3 = new CouponDto("ccc", 10000, 30, 50000, 10000, "ABS");

        couponDao.insert(couponDto1);
        couponDao.insert(couponDto2);
        couponDao.insert(couponDto3);

        // 3. 쿠폰 전체 조회
        List<CouponDto> allCoupons = couponDao.selectAll();

        assertTrue(allCoupons.size() == 3);

        // 4. 추가한 쿠폰정보와 db의 쿠폰정보 비교
        CouponDto firstInsertedCoupon = allCoupons.get(0);
        CouponDto secondInsertedCoupon = allCoupons.get(1);
        CouponDto thirdInsertedCoupon = allCoupons.get(2);

        assertTrue(firstInsertedCoupon.equals(couponDto1));
        assertTrue(secondInsertedCoupon.equals(couponDto2));
        assertTrue(thirdInsertedCoupon.equals(couponDto3));
    }

    @Test
    public void insert() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 10, 30, 50000, 50000, "PER");

        assertTrue(couponDao.insert(couponDto) == 1);

        // 3. 쿠폰 조회
        CouponDto insertedCoupon = couponDao.selectByName("aaa");

        // 4. 추가한 쿠폰정보와 db의 쿠폰정보 비교
        assertTrue(insertedCoupon.equals(couponDto));
    }

    @Test
    public void deleteAll() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 데이터 삽입
        CouponDto couponDto = new CouponDto("aaa", 10, 30, 50000, 50000, "PER");

        assertTrue(couponDao.insert(couponDto) == 1);

        // 3. 데이터 조회
        List<CouponDto> allCoupons = couponDao.selectAll();

        assertTrue(allCoupons.size() == 1);

        // 4. 전부 삭제
        couponDao.deleteAll();

        // 5. 데이터 조회
        allCoupons = couponDao.selectAll();

        assertTrue(allCoupons.size() == 0);

    }

    @Test
    public void delete() throws Exception {

        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. 여러쿠폰 추가
        CouponDto couponDto1 = new CouponDto("aaa", 10, 30, 50000, 100000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 20, 60, 10000, 50000, "PER");
        CouponDto couponDto3 = new CouponDto("ccc", 10000, 30, 50000, 10000, "ABS");

        couponDao.insert(couponDto1);
        couponDao.insert(couponDto2);
        couponDao.insert(couponDto3);

        // 3. 데이터 조회
        List<CouponDto> allCoupons = couponDao.selectAll();

        assertTrue(allCoupons.size() == 3);

        // 3. 일부쿠폰 삭제
        assertTrue(couponDao.deleteByName("aaa") == 1);
        assertTrue(couponDao.deleteByName("ccc") == 1);

        // 4. 데이터 조회
        allCoupons = couponDao.selectAll();

        assertTrue(allCoupons.size() == 1);
    }

    @Test
    public void update() throws Exception {
        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 10, 30, 50000, 50000, "PER");

        couponDao.insert(couponDto);

        // 3. 쿠폰 조회 & 쿠폰 개수 확인
        CouponDto insertedCoupon = couponDao.selectByName("aaa");

        assertTrue(insertedCoupon.equals(couponDto));

        assertTrue(couponDao.count() == 1);

        // 4. 쿠폰 변경
        CouponDto newCouponDto = new CouponDto("aaa", 20, 40, 60000, 60000, "PER");

        System.out.println(couponDao.update(newCouponDto));
        assertTrue(couponDao.update(newCouponDto) == 1);

        // 5. 쿠폰 조회 & 쿠폰 개수 확인
        CouponDto updatedCoupon = couponDao.selectByName("aaa");

        assertTrue(updatedCoupon.equals(newCouponDto));

        assertTrue(couponDao.update(newCouponDto) == 1);


    }

    @Test
    public void selectByNameNoRow() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 조회
        assertNull(couponDao.selectByName("bbb"));

    }
    @Test
    public void selectBySeqNoRow() throws Exception {

        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 조회
        assertNull(couponDao.selectBySeq(1));

    }

    @Test
    public void selectWithoutName() throws Exception {

        // 1. 이름없이 쿠폰 조회
        CouponDto noNameCoupon = couponDao.selectByName("");

        assertNull(noNameCoupon);
    }

    @Test
    public void bulkInsert() throws Exception {

        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. 대량 쿠폰 추가
        for(int i=0; i<1000; i++) {
            CouponDto couponDto = new CouponDto("aaa" + i, 10,30, 50000, 50000, "PER");
            couponDao.insert(couponDto);
        }

        // 3. 개수 확인
        assertTrue(couponDao.count() == 1000);
    }

    @Test
    public void insertWithoutName() throws Exception {

        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. name없는 dto로 쿠폰 추가
        CouponDto couponDto = new CouponDto(null, 20, 40, 60000, 60000, "PER");

        assertNull(couponDto.getName());

        // 3. 예외 발생하면 통과
        try {
            couponDao.insert(couponDto);
            fail("DataIntegrityViolationException예외가 발생하지 않음");
        } catch (DataIntegrityViolationException e) {
            assertTrue(couponDao.count() == 0);
        }


    }

    @Test
    public void duplicateInsert() throws Exception {

        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 추가
        CouponDto couponDto = new CouponDto("aaa", 20, 40, 60000, 60000, "PER");

        couponDao.insert(couponDto);

        assertTrue(couponDao.count() == 1);

        // 3. 쿠폰 추가
        try {
            couponDao.insert(couponDto);
            fail("DuplicateKeyException예외가 발생하지 않음");
        } catch(DuplicateKeyException e) {
            assertTrue(couponDao.count() == 1);
        }

    }

    @Test
    public void deleteNonexistentName() throws Exception {
        // 1. 전부 삭제
        deleteAllAndCheckCount();

        // 2. 쿠폰 삭제
        assertTrue(couponDao.deleteByName("aaa") == 0);

    }

    @Test
    public void bulkDelete() throws Exception {
        // 1. 전체 삭제
        deleteAllAndCheckCount();

        // 2. 대량 쿠폰 추가
        for(int i=0; i<1000; i++) {
            CouponDto couponDto = new CouponDto("aaa" + i, 10,30, 50000, 50000, "PER");
            couponDao.insert(couponDto);
        }

        assertTrue(couponDao.count() == 1000);

        // 3. 쿠폰 전체 제거
        couponDao.deleteAll();

        assertTrue(couponDao.count() == 0);
    }


    private void deleteAllAndCheckCount() throws Exception {
        couponDao.deleteAll();
        assertTrue(couponDao.count() == 0);
    }


}