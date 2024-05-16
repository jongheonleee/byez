package com.neo.byez.domain.order;

import java.util.Objects;

public class PayHistoryDto {
    private String pay_num;
    private Integer seq;
    private Integer price;
    private String state;
    private String rec_date;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public PayHistoryDto(){}

    public PayHistoryDto(String pay_num, Integer seq, Integer price, String state) {
        this.pay_num = pay_num;
        this.seq = seq;
        this.price = price;
        this.state = state;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRec_date() {
        return rec_date;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayHistoryDto that = (PayHistoryDto) o;
        return Objects.equals(getPay_num(), that.getPay_num()) && Objects.equals(getSeq(), that.getSeq()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getState(), that.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPay_num(), getSeq(), getPrice(), getState());
    }

    @Override
    public String toString() {
        return "{" +
                "pay_num='" + pay_num + '\'' +
                ", seq=" + seq +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", rec_date='" + rec_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
