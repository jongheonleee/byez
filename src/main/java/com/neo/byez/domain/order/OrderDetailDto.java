package com.neo.byez.domain.order;

import java.util.Objects;

public class OrderDetailDto {
    private String ord_num;
    private Integer seq;
    private String item_num;
    private String id;
    private String item_name;
    private Integer price;
    private String item_comt;
    private Integer item_qty;
    private Integer item_price;
    private String  ord_date;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String opt5;
    private String ord_state;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public OrderDetailDto(){

    }

    public OrderDetailDto(String ord_num, String item_num, String id, String item_name, Integer price, Integer item_qty, Integer item_price, String opt1, String opt2, String ord_state) {
        this.ord_num = ord_num;
        this.item_num = item_num;
        this.id = id;
        this.item_name = item_name;
        this.price = price;
        this.item_qty = item_qty;
        this.item_price = item_price;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.ord_state = ord_state;
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

    public String getItem_num() {
        return item_num;
    }

    public void setItem_num(String item_num) {
        this.item_num = item_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getItem_comt() {
        return item_comt;
    }

    public void setItem_comt(String item_comt) {
        this.item_comt = item_comt;
    }

    public Integer getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(Integer item_qty) {
        this.item_qty = item_qty;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }

    public String getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(String ord_date) {
        this.ord_date = ord_date;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getOpt5() {
        return opt5;
    }

    public void setOpt5(String opt5) {
        this.opt5 = opt5;
    }

    public String getOrd_state() {
        return ord_state;
    }

    public void setOrd_state(String ord_state) {
        this.ord_state = ord_state;
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
        this.setId(id);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailDto that = (OrderDetailDto) o;
        return Objects.equals(getOrd_num(), that.getOrd_num()) && Objects.equals(getSeq(), that.getSeq()) && Objects.equals(getItem_num(), that.getItem_num()) && Objects.equals(getId(), that.getId()) && Objects.equals(getItem_name(), that.getItem_name()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getItem_comt(), that.getItem_comt()) && Objects.equals(getItem_qty(), that.getItem_qty()) && Objects.equals(getItem_price(), that.getItem_price()) && Objects.equals(getOpt1(), that.getOpt1()) && Objects.equals(getOpt2(), that.getOpt2()) && Objects.equals(getOpt3(), that.getOpt3()) && Objects.equals(getOpt4(), that.getOpt4()) && Objects.equals(getOpt5(), that.getOpt5());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrd_num(), getSeq(), getItem_num(), getId(), getItem_name(), getPrice(), getItem_comt(), getItem_qty(), getItem_price(), getOpt1(), getOpt2(), getOpt3(), getOpt4(), getOpt5());
    }

    @Override
    public String toString() {
        return "{" +
                "ord_num='" + ord_num + '\'' +
                ", seq=" + seq +
                ", item_num=" + item_num +
                ", id='" + id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", price=" + price +
                ", item_comt='" + item_comt + '\'' +
                ", item_qty=" + item_qty +
                ", item_price=" + item_price +
                ", ord_date='" + ord_date + '\'' +
                ", opt1='" + opt1 + '\'' +
                ", opt2='" + opt2 + '\'' +
                ", opt3='" + opt3 + '\'' +
                ", opt4='" + opt4 + '\'' +
                ", opt5='" + opt5 + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
