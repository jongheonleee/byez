package com.neo.byez.service;

import com.neo.byez.domain.CouponDto;
import com.neo.byez.domain.CustCouponsDto;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.UserCouponDetails;
import com.neo.byez.common.exception.CouponManipulationException;
import com.neo.byez.common.exception.OrderManipulationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CustCouponsServiceTest {

    @Autowired
    CustCouponsServiceImpl custCouponsService;

    @Autowired
    CouponServiceImpl couponService;

    @Test
    public void getUserCouponDetailsByUserId() throws Exception {

        // 1. 쿠폰 종류 초기화
        couponService.removeAllCouponType();

        CouponDto aaaCouponDto = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto bbbCouponDto = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponService.createCouponType(aaaCouponDto);
        couponService.createCouponType(bbbCouponDto);

        CouponDto coupon1 = couponService.getCouponInfoByName("aaa");
        CouponDto coupon2 = couponService.getCouponInfoByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponService.countCouponTypes() == 2);

        // 2. 보유 쿠폰 전부 삭제
        custCouponsService.deleteAllCouponHistory();
        assertTrue(custCouponsService.getTotalCouponCount() == 0);

        // 3. 유저에게 쿠폰 지급
        custCouponsService.grantCouponToUser("userId1", "aaa");

        List<CustCouponsDto> userCoupons = custCouponsService.getCouponsByUserId("userId1");
        CustCouponsDto firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1"));

        // 4. 보유 쿠폰 정보 가져옴
        List<UserCouponDetails> userCouponDetailsList = custCouponsService.getUserCouponDetailsByUserId("userId1");
        UserCouponDetails couponDetail = userCouponDetailsList.get(0);
        
        assertTrue(couponDetail.getCouponDto().equals(aaaCouponDto));
        assertTrue(couponDetail.getCustCouponsDto().equals(firstUserCoupon));

    }

    @Test
    public void testValidOrder() throws Exception {

        // 1. 쿠폰 종류 초기화
        couponService.removeAllCouponType();

        CouponDto couponDto1 = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponService.createCouponType(couponDto1);
        couponService.createCouponType(couponDto2);

        CouponDto coupon1 = couponService.getCouponInfoByName("aaa");
        CouponDto coupon2 = couponService.getCouponInfoByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponService.countCouponTypes() == 2);

        // 2. 보유 쿠폰 전부 삭제
        custCouponsService.deleteAllCouponHistory();
        assertTrue(custCouponsService.getTotalCouponCount() == 0);

        // 3. 유저에게 쿠폰 지급
        custCouponsService.grantCouponToUser("userId1", "aaa");

        List<CustCouponsDto> userCoupons = custCouponsService.getCouponsByUserId("userId1");
        CustCouponsDto firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1"));

        // 4. 유효한 주문 정보 가정
        OrderDto validOrderDto = new OrderDto();

        validOrderDto.setTotal_item_qty(1);
        validOrderDto.setTotal_price(100000);
        validOrderDto.setTotal_disc_price(30000);
        validOrderDto.setTotal_pay_price(70000);

        // 5. 쿠폰 검증 및 사용
        int seq = firstUserCoupon.getSeq();
        custCouponsService.validateAndUseCoupon(validOrderDto, couponDto1, seq);

        userCoupons = custCouponsService.getCouponsByUserId("userId1");
        assertTrue(userCoupons.isEmpty()); // 쿠폰 사용처리 되어 남은 쿠폰 없음

    }

    @Test
    public void testInvalidOrderByOrderDto() throws Exception {
        // 1. 쿠폰 종류 초기화
        couponService.removeAllCouponType();

        CouponDto couponDto1 = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponService.createCouponType(couponDto1);
        couponService.createCouponType(couponDto2);

        CouponDto coupon1 = couponService.getCouponInfoByName("aaa");
        CouponDto coupon2 = couponService.getCouponInfoByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponService.countCouponTypes() == 2);

        // 2. 보유 쿠폰 전부 삭제
        custCouponsService.deleteAllCouponHistory();
        assertTrue(custCouponsService.getTotalCouponCount() == 0);

        // 3. 유저에게 쿠폰 지급
        custCouponsService.grantCouponToUser("userId1", "aaa");

        List<CustCouponsDto> userCoupons = custCouponsService.getCouponsByUserId("userId1");
        CustCouponsDto firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1"));

        // 4. 유효하지 않은 주문 정보 가정
        OrderDto invalidOrderDto = new OrderDto();

        invalidOrderDto.setTotal_item_qty(1);
        invalidOrderDto.setTotal_price(100000);
        invalidOrderDto.setTotal_disc_price(50000);
        invalidOrderDto.setTotal_pay_price(50000);

        // 5. 쿠폰 검증 및 사용
        int seq = firstUserCoupon.getSeq();
        try {
            custCouponsService.validateAndUseCoupon(invalidOrderDto, couponDto1, seq);
            fail("주문 정보 조작에 대한 대처를 하지 못했습니다.");
        } catch (OrderManipulationException e) {

        }

        userCoupons = custCouponsService.getCouponsByUserId("userId1");
        firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1")); // 쿠폰 사용처리가 되지 않아야 함

    }

    @Test
    public void testInvalidOrderByCouponDto() throws Exception {
        // 1. 쿠폰 종류 초기화
        couponService.removeAllCouponType();

        CouponDto couponDto1 = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponService.createCouponType(couponDto1);
        couponService.createCouponType(couponDto2);

        CouponDto coupon1 = couponService.getCouponInfoByName("aaa");
        CouponDto coupon2 = couponService.getCouponInfoByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponService.countCouponTypes() == 2);

        // 2. 보유 쿠폰 전부 삭제
        custCouponsService.deleteAllCouponHistory();
        assertTrue(custCouponsService.getTotalCouponCount() == 0);

        // 3. 유저에게 쿠폰 지급
        custCouponsService.grantCouponToUser("userId1", "aaa");

        List<CustCouponsDto> userCoupons = custCouponsService.getCouponsByUserId("userId1");
        CustCouponsDto firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1"));

        // 4. 쿠폰 정보 조작
        couponDto1.setPrmo(40);

        // 5. 조작된 쿠폰으로 유효한 주문 정보 가정
        OrderDto validOrderDto = new OrderDto();
        validOrderDto.setTotal_item_qty(1);
        validOrderDto.setTotal_price(100000);
        validOrderDto.setTotal_disc_price(40000);
        validOrderDto.setTotal_pay_price(60000);

        // 6. 쿠폰 검증 및 사용
        int seq = firstUserCoupon.getSeq();
        try {
            custCouponsService.validateAndUseCoupon(validOrderDto, couponDto1, seq);
            fail("쿠폰 조작에 예외가 발생하지 않았습니다.");
        } catch(CouponManipulationException e) {

        }

        userCoupons = custCouponsService.getCouponsByUserId("userId1");
        firstUserCoupon = userCoupons.get(0);
        assertTrue(firstUserCoupon.getId().equals("userId1")); // 쿠폰 사용처리가 되지 않아야 함


    }

    private void initCouponType() throws Exception {
        couponService.removeAllCouponType();

        CouponDto couponDto1 = new CouponDto("aaa", 30, 30, 50000, 50000, "PER");
        CouponDto couponDto2 = new CouponDto("bbb", 30, 30, 50000, 50000, "PER");
        couponService.createCouponType(couponDto1);
        couponService.createCouponType(couponDto2);

        CouponDto coupon1 = couponService.getCouponInfoByName("aaa");
        CouponDto coupon2 = couponService.getCouponInfoByName("bbb");
        assertTrue(coupon1.getName().equals("aaa"));
        assertTrue(coupon2.getName().equals("bbb"));
        assertTrue(couponService.countCouponTypes() == 2);
    }


}