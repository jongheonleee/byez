package com.neo.byez.domain.order;

import java.util.Date;
import java.util.Objects;

public class OrdEtcReqDto {

    String ord_num;
    int seq;
    String type_code;
    String reason_code;
    String reason_detail;
    Date start_date;
    Date end_date;
    String req_chk;
    String chg_chk;
    String appcn_name;
    String appcn_mobile;
    String zpcd;
    String main_addr;
    String detail_addr;
    Date reg_date;
    String reg_id;
    Date up_date;
    String up_id;

    public OrdEtcReqDto(){

    }
    public OrdEtcReqDto(String ord_num, String type_code, String reason_code, String reason_detail) {
        this.ord_num = ord_num;
        this.type_code = type_code;
        this.reason_code = reason_code;
        this.reason_detail = reason_detail;
    }

    public OrdEtcReqDto(String ord_num, String type_code, String reason_code, String reason_detail, String req_chk, String chg_chk, String appcn_name, String appcn_mobile, String zpcd, String main_addr, String detail_addr) {
        this.ord_num = ord_num;
        this.type_code = type_code;
        this.reason_code = reason_code;
        this.reason_detail = reason_detail;
        this.req_chk = req_chk;
        this.chg_chk = chg_chk;
        this.appcn_name = appcn_name;
        this.appcn_mobile = appcn_mobile;
        this.zpcd = zpcd;
        this.main_addr = main_addr;
        this.detail_addr = detail_addr;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public String getReason_detail() {
        return reason_detail;
    }

    public void setReason_detail(String reason_detail) {
        this.reason_detail = reason_detail;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getReq_chk() {
        return req_chk;
    }

    public void setReq_chk(String req_chk) {
        this.req_chk = req_chk;
    }

    public String getChg_chk() {
        return chg_chk;
    }

    public void setChg_chk(String chg_chk) {
        this.chg_chk = chg_chk;
    }

    public String getAppcn_name() {
        return appcn_name;
    }

    public void setAppcn_name(String appcn_name) {
        this.appcn_name = appcn_name;
    }

    public String getAppcn_mobile() {
        return appcn_mobile;
    }

    public void setAppcn_mobile(String appcn_mobile) {
        this.appcn_mobile = appcn_mobile;
    }

    public String getZpcd() {
        return zpcd;
    }

    public void setZpcd(String zpcd) {
        this.zpcd = zpcd;
    }

    public String getMain_addr() {
        return main_addr;
    }

    public void setMain_addr(String main_addr) {
        this.main_addr = main_addr;
    }

    public String getDetail_addr() {
        return detail_addr;
    }

    public void setDetail_addr(String detail_addr) {
        this.detail_addr = detail_addr;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdEtcReqDto that = (OrdEtcReqDto) o;
        return seq == that.seq && Objects.equals(ord_num, that.ord_num) && Objects.equals(type_code, that.type_code) && Objects.equals(reason_code, that.reason_code) && Objects.equals(reason_detail, that.reason_detail) && Objects.equals(start_date, that.start_date) && Objects.equals(end_date, that.end_date) && Objects.equals(req_chk, that.req_chk) && Objects.equals(chg_chk, that.chg_chk) && Objects.equals(appcn_name, that.appcn_name) && Objects.equals(appcn_mobile, that.appcn_mobile) && Objects.equals(zpcd, that.zpcd) && Objects.equals(main_addr, that.main_addr) && Objects.equals(detail_addr, that.detail_addr) && Objects.equals(reg_date, that.reg_date) && Objects.equals(reg_id, that.reg_id) && Objects.equals(up_date, that.up_date) && Objects.equals(up_id, that.up_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ord_num, seq, type_code, reason_code, reason_detail, start_date, end_date, req_chk, chg_chk, appcn_name, appcn_mobile, zpcd, main_addr, detail_addr, reg_date, reg_id, up_date, up_id);
    }

    @Override
    public String toString() {
        return "OrdEtcReqDto{" +
                "ord_num='" + ord_num + '\'' +
                ", seq=" + seq +
                ", type_code='" + type_code + '\'' +
                ", reason_code='" + reason_code + '\'' +
                ", reason_detail='" + reason_detail + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", req_chk='" + req_chk + '\'' +
                ", chg_chk='" + chg_chk + '\'' +
                ", appcn_name='" + appcn_name + '\'' +
                ", appcn_mobile='" + appcn_mobile + '\'' +
                ", zpcd='" + zpcd + '\'' +
                ", main_addr='" + main_addr + '\'' +
                ", detail_addr='" + detail_addr + '\'' +
                ", reg_date=" + reg_date +
                ", reg_id='" + reg_id + '\'' +
                ", up_date=" + up_date +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
