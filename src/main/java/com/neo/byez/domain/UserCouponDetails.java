package com.neo.byez.domain;

import java.util.Objects;

public class UserCouponDetails {
    private CustCouponsDto custCouponsDto;
    private CouponDto couponDto;

    public UserCouponDetails() {}

    public UserCouponDetails(CustCouponsDto custCouponsDto, CouponDto couponDto) {
        this.custCouponsDto = custCouponsDto;
        this.couponDto = couponDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCouponDetails that = (UserCouponDetails) o;
        return Objects.equals(custCouponsDto, that.custCouponsDto) && Objects.equals(couponDto, that.couponDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custCouponsDto, couponDto);
    }

    public CustCouponsDto getCustCouponsDto() {
        return custCouponsDto;
    }

    public void setCustCouponsDto(CustCouponsDto custCouponsDto) {
        this.custCouponsDto = custCouponsDto;
    }

    public CouponDto getCouponDto() {
        return couponDto;
    }

    public void setCouponDto(CouponDto couponDto) {
        this.couponDto = couponDto;
    }

    @Override
    public String toString() {
        return "UserCouponDetails{" +
                "custCouponsDto=" + custCouponsDto +
                ", couponDto=" + couponDto +
                '}';
    }
}
