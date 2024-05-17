package com.neo.byez.domain.order;

import java.util.Objects;

public class DeliveryDto {
    private String dlv_num;
    private String ord_num;
    private Integer waybill_num;
    private String dlv_corp;
    private String pickup_chk;
    private String rcpr;
    private String rcpr_mobile;
    private String zpcd;
    private String main_addr;
    private String detail_addr;
    private String msg;
    private String start_date;
    private String end_date;
    private String state;
    private String remark;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public DeliveryDto(){

    }

    public DeliveryDto(String ord_num, String pickup_chk, String rcpr, String rcpr_mobile, String zpcd, String main_addr, String detail_addr) {
        this.ord_num = ord_num;
        this.pickup_chk = pickup_chk;
        this.rcpr = rcpr;
        this.rcpr_mobile = rcpr_mobile;
        this.zpcd = zpcd;
        this.main_addr = main_addr;
        this.detail_addr = detail_addr;
    }

    public String getDlv_num() {
        return dlv_num;
    }

    public void setDlv_num(String dlv_num) {
        this.dlv_num = dlv_num;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public Integer getWaybill_num() {
        return waybill_num;
    }

    public void setWaybill_num(Integer waybill_num) {
        this.waybill_num = waybill_num;
    }

    public String getDlv_corp() {
        return dlv_corp;
    }

    public void setDlv_corp(String dlv_corp) {
        this.dlv_corp = dlv_corp;
    }

    public String getPickup_chk() {
        return pickup_chk;
    }

    public void setPickup_chk(String pickup_chk) {
        this.pickup_chk = pickup_chk;
    }

    public String getRcpr() {
        return rcpr;
    }

    public void setRcpr(String rcpr) {
        this.rcpr = rcpr;
    }

    public String getRcpr_mobile() {
        return rcpr_mobile;
    }

    public void setRcpr_mobile(String rcpr_mobile) {
        this.rcpr_mobile = rcpr_mobile;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

    public void setSaveReadyInfo(String ord_num, String id){
        this.setOrd_num(ord_num);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDto that = (DeliveryDto) o;
        return Objects.equals(getDlv_num(), that.getDlv_num()) && Objects.equals(getOrd_num(), that.getOrd_num()) && Objects.equals(getWaybill_num(), that.getWaybill_num()) && Objects.equals(getDlv_corp(), that.getDlv_corp()) && Objects.equals(getPickup_chk(), that.getPickup_chk()) && Objects.equals(getRcpr(), that.getRcpr()) && Objects.equals(getRcpr_mobile(), that.getRcpr_mobile()) && Objects.equals(getZpcd(), that.getZpcd()) && Objects.equals(getMain_addr(), that.getMain_addr()) && Objects.equals(getDetail_addr(), that.getDetail_addr()) && Objects.equals(getMsg(), that.getMsg()) && Objects.equals(getState(), that.getState()) && Objects.equals(getRemark(), that.getRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDlv_num(), getOrd_num(), getWaybill_num(), getDlv_corp(), getPickup_chk(), getRcpr(), getRcpr_mobile(), getZpcd(), getMain_addr(), getDetail_addr(), getMsg(), getState(), getRemark());
    }

    @Override
    public String toString() {
        return "{" +
                "dlv_num='" + dlv_num + '\'' +
                ", ord_num='" + ord_num + '\'' +
                ", waybill_num=" + waybill_num +
                ", dlv_corp='" + dlv_corp + '\'' +
                ", pickup_chk='" + pickup_chk + '\'' +
                ", rcpr='" + rcpr + '\'' +
                ", rcpr_mobile='" + rcpr_mobile + '\'' +
                ", zpcd='" + zpcd + '\'' +
                ", main_addr='" + main_addr + '\'' +
                ", detail_addr='" + detail_addr + '\'' +
                ", msg='" + msg + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", state='" + state + '\'' +
                ", remark='" + remark + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
