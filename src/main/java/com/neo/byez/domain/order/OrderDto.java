package com.neo.byez.domain.order;

import java.util.Objects;

public class OrderDto {
    private String ord_num;             // 주문번호
    private String id;                  // 고객 ID
    private Integer total_item_qty;     // 총 주문상품수량
    private Integer total_price;        // 총 주문금액
    private Integer total_dlv_price;    // 총 배송비
    private Integer total_disc_price;   // 총 할인금액
    private Integer total_pay_price;    // 최종 결제금액
    private String ord_date;
    private String ord_state;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public OrderDto() {}

    public OrderDto(String ord_num, String id, Integer total_item_qty, Integer total_price, Integer total_dlv_price, Integer total_disc_price, Integer total_pay_price, String ord_state) {
        this.ord_num = ord_num;
        this.id = id;
        this.total_item_qty = total_item_qty;
        this.total_price = total_price;
        this.total_dlv_price = total_dlv_price;
        this.total_disc_price = total_disc_price;
        this.total_pay_price = total_pay_price;
        this.ord_state = ord_state;
        this.reg_id = id;
        this.up_id = id;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal_item_qty() {
        return total_item_qty;
    }

    public void setTotal_item_qty(Integer total_item_qty) {
        this.total_item_qty = total_item_qty;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Integer getTotal_dlv_price() {
        return total_dlv_price;
    }

    public void setTotal_dlv_price(Integer total_dlv_price) {
        this.total_dlv_price = total_dlv_price;
    }

    public Integer getTotal_disc_price() {
        return total_disc_price;
    }

    public void setTotal_disc_price(Integer total_disc_price) {
        this.total_disc_price = total_disc_price;
    }

    public Integer getTotal_pay_price() {
        return total_pay_price;
    }

    public void setTotal_pay_price(Integer total_pay_price) {
        this.total_pay_price = total_pay_price;
    }

    public String getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(String ord_date) {
        this.ord_date = ord_date;
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

    public void setSaveReadyInfo(String id){
        this.setId(id);
        this.setReg_id(id);
        this.setUp_id(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(getOrd_num(), orderDto.getOrd_num()) && Objects.equals(getId(), orderDto.getId()) && Objects.equals(getTotal_item_qty(), orderDto.getTotal_item_qty()) && Objects.equals(getTotal_price(), orderDto.getTotal_price()) && Objects.equals(getTotal_dlv_price(), orderDto.getTotal_dlv_price()) && Objects.equals(getTotal_disc_price(), orderDto.getTotal_disc_price()) && Objects.equals(getTotal_pay_price(), orderDto.getTotal_pay_price()) && Objects.equals(getOrd_state(), orderDto.getOrd_state());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrd_num(), getId(), getTotal_item_qty(), getTotal_price(), getTotal_dlv_price(), getTotal_disc_price(), getTotal_pay_price(), getOrd_state());
    }

    @Override
    public String toString() {
        return "{" +
                "ord_num='" + ord_num + '\'' +
                ", id='" + id + '\'' +
                ", total_item_qty=" + total_item_qty +
                ", total_price=" + total_price +
                ", total_dlv_price=" + total_dlv_price +
                ", total_disc_price=" + total_disc_price +
                ", total_pay_price=" + total_pay_price +
                ", ord_date='" + ord_date + '\'' +
                ", ord_state='" + ord_state + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", up_date='" + up_date + '\'' +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
