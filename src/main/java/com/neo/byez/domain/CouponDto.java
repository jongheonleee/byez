package com.neo.byez.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class CouponDto {

    int seq;
    @NotBlank(message = "쿠폰 이름을 입력하세요.")
    private String name;

    @NotNull(message = "할인을 입력하세요.")
    @Min(value = 1, message = "할인은 1 이상의 숫자여야 합니다.")
    private Integer prmo;

    @NotNull(message = "유효기간을 입력하세요.")
    @Min(value = 1, message = "유효기간은 1 이상의 숫자여야 합니다.")
    private Integer validDay;

    @Min(value = 0, message = "최소 결제 금액은 0 이상의 숫자여야 합니다.")
    private int minPayPrice;

    @Min(value = 0, message = "최대 할인 금액은 0 이상의 숫자여야 합니다.")
    private int maxDiscPrice;

    private String ableChk = "Y";

    @NotBlank(message = "할인 유형을 입력하세요 (PER 또는 ABS).")
    private String discType;

    String comt;
    String remark;
    Date regDate;
    String regId;
    Date upDate;
    String upId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponDto couponDto = (CouponDto) o;
        return minPayPrice == couponDto.minPayPrice && maxDiscPrice == couponDto.maxDiscPrice && Objects.equals(name, couponDto.name) && Objects.equals(prmo, couponDto.prmo) && Objects.equals(validDay, couponDto.validDay) && Objects.equals(discType, couponDto.discType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prmo, validDay, minPayPrice, maxDiscPrice, discType);
    }

    public CouponDto() {}

    public CouponDto(String name, Integer prmo, Integer validDay, int minPayPrice, int maxDiscPrice, String discType) {
        this.name = name;
        this.prmo = prmo;
        this.validDay = validDay;
        this.minPayPrice = minPayPrice;
        this.maxDiscPrice = maxDiscPrice;
        this.discType = discType;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrmo() {
        return prmo;
    }

    public void setPrmo(Integer prmo) {
        this.prmo = prmo;
    }

    public int getValidDay() {
        return validDay;
    }

    public void setValidDay(Integer validDay) {
        this.validDay = validDay;
    }

    public int getMinPayPrice() {
        return minPayPrice;
    }

    public void setMinPayPrice(int minPayPrice) {
        this.minPayPrice = minPayPrice;
    }

    public int getMaxDiscPrice() {
        return maxDiscPrice;
    }

    public void setMaxDiscPrice(int maxDiscPrice) {
        this.maxDiscPrice = maxDiscPrice;
    }

    public String getAbleChk() {
        return ableChk;
    }

    public void setAbleChk(String ableChk) {
        this.ableChk = ableChk;
    }

    public String getDiscType() {
        return discType;
    }

    public void setDiscType(String discType) {
        this.discType = discType;
    }

    public String getComt() {
        return comt;
    }

    public void setComt(String comt) {
        this.comt = comt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    @Override
    public String toString() {
        return "CouponDto{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", prmo=" + prmo +
                ", validDay=" + validDay +
                ", minPayPrice=" + minPayPrice +
                ", maxDiscPrice=" + maxDiscPrice +
                ", ableChk='" + ableChk + '\'' +
                ", discType='" + discType + '\'' +
                ", comt='" + comt + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
