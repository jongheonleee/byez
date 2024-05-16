package com.neo.byez.domain.order;

import java.util.List;

public class OrderResultInfo {
    /*
        주문 상세 페이지

        1. 주문자정보
        2. 배송지정보
        3. 주문상품정보
        4. 주문정보
        5. 결제정보

        결제 -> 주문상세

        주문번호에 해당하는 주문상세정보 조회
     */

    // 주문상품 정보
    private List<OrderDetailDto> orderDetailDtoList;


    // 주문 정보
    private String ord_num;             // 주문번호
    private String id;                  // 구매자 ID
    private Integer total_item_qty;     // 총 주문상품 수량
    private Integer total_price;        // 총 주문상품 금액
    private Integer total_dlv_price;    // 총 배송비
    private Integer total_disc_price;   // 총 할인금액
    private Integer total_pay_price;    // 총 결제금액
    private String ord_date;            // 주문 일시
    private String ord_state;           // 주문상태


    // 배송지 정보
    private String dlv_num;             // 배송번호
    private Integer waybill_num;        // 운송장번호
    private String dlv_corp;            // 택배회사
    private String pickup_chk;          // 수거 요청 여부
    private String rcpr;                // 수령인
    private String rcpr_mobile;         // 수령인 전화번호
    private String zpcd;                // 우편번호
    private String main_addr;           // 기본주소
    private String detail_addr;         // 상세주소
    private String msg;                 // 배송메시지
    private String state;               // 배송상태

    public OrderResultInfo(){}

    public List<OrderDetailDto> getOrderDetailDtoList() {
        return orderDetailDtoList;
    }

    public void setOrderDetailDtoList(List<OrderDetailDto> orderDetailDtoList) {
        this.orderDetailDtoList = orderDetailDtoList;
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

    public String getDlv_num() {
        return dlv_num;
    }

    public void setDlv_num(String dlv_num) {
        this.dlv_num = dlv_num;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderResultInfo{" +
                "\norderDetailDtoList=" + orderDetailDtoList +
                "\n, ord_num='" + ord_num + '\'' +
                "\n, id='" + id + '\'' +
                "\n, total_item_qty=" + total_item_qty +
                "\n, total_price=" + total_price +
                "\n, total_dlv_price=" + total_dlv_price +
                "\n, total_disc_price=" + total_disc_price +
                "\n, total_pay_price=" + total_pay_price +
                "\n, ord_date='" + ord_date + '\'' +
                "\n, ord_state='" + ord_state + '\'' +
                "\n, dlv_num='" + dlv_num + '\'' +
                "\n, waybill_num=" + waybill_num +
                "\n, dlv_corp='" + dlv_corp + '\'' +
                "\n, pickup_chk='" + pickup_chk + '\'' +
                "\n, rcpr='" + rcpr + '\'' +
                "\n, rcpr_mobile='" + rcpr_mobile + '\'' +
                "\n, zpcd='" + zpcd + '\'' +
                "\n, main_addr='" + main_addr + '\'' +
                "\n, detail_addr='" + detail_addr + '\'' +
                "\n, msg='" + msg + '\'' +
                "\n, state='" + state + '\'' +
                '}';
    }
}
