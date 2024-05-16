package com.neo.byez.domain.order;

import java.util.Objects;

public class PayStateDto {
    private String pay_num;
    private Integer seq;
    private String state_code;
    private String state_chg_date;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public PayStateDto(){}

    public PayStateDto(String pay_num, Integer seq, String state_code){
        this.pay_num = pay_num;
        this.seq = seq;
        this.state_code = state_code;
    }

    public String getPay_num() {
        return pay_num;
    }

    public void setPay_num(String pay_num) {
        this.pay_num = pay_num;
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

    public String getState_chg_date() {
        return state_chg_date;
    }

    public void setState_chg_date(String state_chg_date) {
        this.state_chg_date = state_chg_date;
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

    public void setSaveReadyInfo(String id, Integer seq, String pay_num, String state_code){
        this.setPay_num(pay_num);
        this.setSeq(seq);
        this.setState_code(state_code);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayStateDto that = (PayStateDto) o;
        return Objects.equals(getPay_num(), that.getPay_num()) && Objects.equals(getSeq(), that.getSeq()) && Objects.equals(getState_code(), that.getState_code());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPay_num(), getSeq(), getState_code());
    }

    @Override
    public String toString() {
        return "{" +
                "pay_num='" + pay_num + '\'' +
                ", seq=" + seq +
                ", state_code='" + state_code + '\'' +
                ", state_chg_date='" + state_chg_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
