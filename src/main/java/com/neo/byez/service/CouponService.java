package com.neo.byez.service;

import com.neo.byez.domain.CouponDto;

import java.util.List;

public interface CouponService {
    int countCouponTypes() throws Exception;

    CouponDto getCouponInfoByName(String couponName) throws Exception;

    List<CouponDto> getAllCouponInfo() throws Exception;

    int createCouponType(CouponDto couponDto) throws Exception;

    int removeAllCouponType() throws Exception;

    int removeCouponTypeByName(String couponName) throws Exception;

    int updateCouponInfo(CouponDto couponDto) throws Exception;
}
