package com.neo.byez.domain;

import java.util.Date;
import java.util.Objects;

public class CustCouponsDto {

    int seq;
    String id;
    int couponSeq;
    String issueDate;
    String expDate;
    String couponState;
    Date regDate;
    String regId;
    Date upDate;
    String upId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustCouponsDto that = (CustCouponsDto) o;
        return couponSeq == that.couponSeq && Objects.equals(id, that.id) && Objects.equals(couponState, that.couponState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, couponSeq, couponState);
    }

    public CustCouponsDto() {}

    public CustCouponsDto(String id, int couponSeq) {
        this.id = id;
        this.couponSeq = couponSeq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCouponSeq() {
        return couponSeq;
    }

    public void setCouponSeq(int couponSeq) {
        this.couponSeq = couponSeq;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCouponState() {
        return couponState;
    }

    public void setCouponState(String couponState) {
        this.couponState = couponState;
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
        return "CustCouponsDto{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", couponSeq=" + couponSeq +
                ", issueDate='" + issueDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", couponState='" + couponState + '\'' +
                ", regDate=" + regDate +
                ", regId='" + regId + '\'' +
                ", upDate=" + upDate +
                ", upId='" + upId + '\'' +
                '}';
    }
}
