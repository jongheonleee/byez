package com.neo.byez.domain.order;

import java.util.Objects;

public class OrderStateDto {
    private String ord_num;
    private Integer seq;
    private String state_code;
    private String chg_date;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public OrderStateDto(){}

    public OrderStateDto(String ord_num, Integer seq, String state_code, String id){
        this.ord_num = ord_num;
        this.seq = seq;
        this.state_code = state_code;
        this.reg_id = id;
        this.up_id = id;
    }

    public OrderStateDto(String ord_num, String state_code){
        this.ord_num = ord_num;
        this.state_code = state_code;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getChg_date() {
        return chg_date;
    }

    public void setChg_date(String chg_date) {
        this.chg_date = chg_date;
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

    public void setSaveReadyInfo(String id, Integer seq, String ord_num, String state_code){
        this.setSeq(seq);
        this.setOrd_num(ord_num);
        this.setState_code(state_code);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStateDto that = (OrderStateDto) o;
        return Objects.equals(getOrd_num(), that.getOrd_num()) && Objects.equals(getSeq(), that.getSeq()) && Objects.equals(getState_code(), that.getState_code());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrd_num(), getSeq(), getState_code());
    }

    @Override
    public String toString() {
        return "{" +
                "ord_num='" + ord_num + '\'' +
                ", seq=" + seq +
                ", state_code='" + state_code + '\'' +
                ", chg_date='" + chg_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
