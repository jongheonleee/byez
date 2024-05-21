package com.neo.byez.domain.order;

import java.util.Objects;

public class PayDto {
    private String pay_num;             // 결제번호
    private String ord_num;             // 주문번호
    private Integer price;              // 결제금액
    private String mtd_code;            // 결제수단
    private Integer card_appv_num;      // 카드승인번호
    private Integer card_cncl_num;      // 카드취소번호
    private String pay_date;            // 결제일시
    private String state;               // 결제상태
    private String remark;              // 비고
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public String getPay_num() {
        return pay_num;
    }

    public void setPay_num(String pay_num) {
        this.pay_num = pay_num;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMtd_code() {
        return mtd_code;
    }

    public void setMtd_code(String mtd_code) {
        this.mtd_code = mtd_code;
    }

    public Integer getCard_appv_num() {
        return card_appv_num;
    }

    public void setCard_appv_num(Integer card_appv_num) {
        this.card_appv_num = card_appv_num;
    }

    public Integer getCard_cncl_num() {
        return card_cncl_num;
    }

    public void setCard_cncl_num(Integer card_cncl_num) {
        this.card_cncl_num = card_cncl_num;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
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

    public void setSaveReadyInfo(String ord_num, String id, String pay_state){
        this.setOrd_num(ord_num);
        this.setState(pay_state);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayDto payDto = (PayDto) o;
        return Objects.equals(getPay_num(), payDto.getPay_num()) && Objects.equals(getOrd_num(), payDto.getOrd_num()) && Objects.equals(getPrice(), payDto.getPrice()) && Objects.equals(getMtd_code(), payDto.getMtd_code()) && Objects.equals(getCard_appv_num(), payDto.getCard_appv_num()) && Objects.equals(getCard_cncl_num(), payDto.getCard_cncl_num()) && Objects.equals(getPay_date(), payDto.getPay_date()) && Objects.equals(getState(), payDto.getState()) && Objects.equals(getRemark(), payDto.getRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPay_num(), getOrd_num(), getPrice(), getMtd_code(), getCard_appv_num(), getCard_cncl_num(), getPay_date(), getState(), getRemark());
    }

    @Override
    public String toString() {
        return "{" +
                "pay_num='" + pay_num + '\'' +
                ", ord_num='" + ord_num + '\'' +
                ", price=" + price +
                ", mtd_code='" + mtd_code + '\'' +
                ", card_appv_num=" + card_appv_num +
                ", card_cncl_num=" + card_cncl_num +
                ", pay_date='" + pay_date + '\'' +
                ", state='" + state + '\'' +
                ", remark='" + remark + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
