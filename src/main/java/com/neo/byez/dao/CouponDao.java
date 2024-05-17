package com.neo.byez.dao;

import com.neo.byez.domain.CouponDto;

import java.util.List;

public interface CouponDao {
    int count() throws Exception;

    CouponDto selectByName(String couponName) throws Exception;

    CouponDto selectBySeq(Integer seq) throws Exception;
    List<CouponDto> selectAll() throws Exception;

    int insert(CouponDto couponDto) throws Exception;

    int deleteAll() throws Exception;

    int deleteByName(String name) throws Exception;

    int update(CouponDto couponDto) throws Exception;
}
