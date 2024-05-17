package com.neo.byez.service;

import com.neo.byez.domain.CouponDto;
import com.neo.byez.domain.CustCouponsDto;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.UserCouponDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustCouponsService {
    int getTotalCouponCount() throws Exception;

    List<CustCouponsDto> getAllUserCoupons() throws Exception;

    List<CustCouponsDto> getCouponsByUserId(String userId) throws Exception;

    void grantCouponToUser(String userId, String couponName) throws Exception;

    boolean deleteCouponHistory(Integer seq) throws Exception;

    int deleteAllCouponHistory() throws Exception;

    boolean useCoupon(Integer seq) throws Exception;

    // 유저의 id로 쿠폰발행정보와 그 쿠폰들의 상세정보를 얻어옴
    List<UserCouponDetails> getUserCouponDetailsByUserId(String userId) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void validateAndUseCoupon(OrderDto orderDto, CouponDto couponDto, Integer seq) throws Exception;
}
