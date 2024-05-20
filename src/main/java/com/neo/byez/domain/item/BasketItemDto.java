package com.neo.byez.domain.item;

import java.util.Date;
import java.util.Objects;

// 장바구니 페이지 활용
public class BasketItemDto {
    private int seq;
    private String id;
    private String num;
    private String name;
    private int price;
    private int qty;
    private String opt1; // 사이즈
    private String opt2; // 색상
    private String opt3;
    private String opt4;
    private String opt5;
    private String coupon_chk;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public BasketItemDto() {}

    public BasketItemDto(int seq, String id, String num, String name, int price, int qty,
            String opt1,
            String opt2, String opt3, String opt4, String opt5, String coupon_chk, Date reg_date,
            String reg_id, Date up_date, String up_id) {
        this.seq = seq;
        this.id = id;
        this.num = num;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.opt5 = opt5;
        this.coupon_chk = coupon_chk;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }



    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public String getCoupon_chk() {
        return coupon_chk;
    }

    public void setCoupon_chk(String coupon_chk) {
        this.coupon_chk = coupon_chk;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BasketItemDto that = (BasketItemDto) o;
        return num.equals(that.num) &&
                name.equals(that.name) &&
                opt1.equals(that.opt1) &&
                opt2.equals(that.opt2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name, opt1, opt2, opt3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[").append("seq : ").append(seq)
                .append(", num : ").append(num)
                .append(", id : ").append(id)
                .append(", name : ").append(name)
                .append(", price : ").append(price)
                .append(", qty : ").append(qty)
                .append(", opt1 : ").append(opt1)
                .append(", opt2 : ").append(opt2)
                .append(", coupon_chk : ").append(coupon_chk)
                .append("]");

        return sb.toString();
    }
}
