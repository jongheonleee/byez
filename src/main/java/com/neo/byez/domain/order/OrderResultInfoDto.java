package com.neo.byez.domain.order;


public class OrderResultInfoDto {
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

    // 1. 주문상품 정보
    // 1.1. 주문번호 및 주문일자
    // 1.2. 상품명, 사이즈, 색상

    // ord 테이블 컬럼
    private String ord_num;             // 주문번호
    private Integer total_price;        // 총 주문상품 금액
    private Integer total_dlv_price;    // 총 배송비
    private Integer total_disc_price;   // 총 할인금액
    private Integer total_pay_price;    // 총 결제금액
    private String ord_date;            // 주문 일시
    private String ord_state;           // 주문 상태

    // ord_detail 테이블 컬럼
    private String item_num;
    private String item_name;           // 상품명
    private String main_img;
    private String opt1;                // 사이즈
    private String opt2;                // 색상
    private String opt3;                // 여성, 남성, 혼성
    private Integer item_qty;           // 상품수량
    private Integer item_price;         // 주문상품 가격

    // dlv 테이블 컬럼
    private Integer waybill_num;        // 운송장번호
    private String dlv_corp;            // 택배회사
    private String dlv_state;           // 배송상태
    private String rcpr;                // 수령인
    private String rcpr_mobile;         // 수령인 전화번호
    private String main_addr;           // 기본주소
    private String detail_addr;         // 상세주소
    private String msg;                 // 배송메시지

    // pay 테이블 컬럼
    private String pay_num;             // 결제번호
    private String pay_state;           // 결제상태
    private Integer card_appv_num;      // 카드결제 승인번호
    private Integer card_cncl_num;      // 카드결제 승인취소 번호
    private String mtd_code;            // 결제수단 코드

    // 주문내역 조회


    public OrderResultInfoDto() {}

    // 주문번호, 주문일자, 주문금액, 배송비, 배송정보, 배송지 정보(ALL), 최종 결제 정보(ALL)


    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
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

    public String getItem_num() {
        return item_num;
    }

    public void setItem_num(String item_num) {
        this.item_num = item_num;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
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

    public String getDlv_state() {
        return dlv_state;
    }

    public void setDlv_state(String dlv_state) {
        this.dlv_state = dlv_state;
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

    public String getPay_num() {
        return pay_num;
    }

    public void setPay_num(String pay_num) {
        this.pay_num = pay_num;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
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

    public String getMtd_code() {
        return mtd_code;
    }

    public void setMtd_code(String mtd_code) {
        this.mtd_code = mtd_code;
    }

    @Override
    public String toString() {
        return "OrderResultInfoDto{" +
                "ord_num='" + ord_num + '\'' +
                ", total_price=" + total_price +
                ", total_dlv_price=" + total_dlv_price +
                ", total_disc_price=" + total_disc_price +
                ", total_pay_price=" + total_pay_price +
                ", ord_date='" + ord_date + '\'' +
                ", ord_state='" + ord_state + '\'' +
                ", item_num='" + item_num + '\'' +
                ", item_name='" + item_name + '\'' +
                ", main_img='" + main_img + '\'' +
                ", opt1='" + opt1 + '\'' +
                ", opt2='" + opt2 + '\'' +
                ", opt3='" + opt3 + '\'' +
                ", item_qty=" + item_qty +
                ", item_price=" + item_price +
                ", waybill_num=" + waybill_num +
                ", dlv_corp='" + dlv_corp + '\'' +
                ", dlv_state='" + dlv_state + '\'' +
                ", rcpr='" + rcpr + '\'' +
                ", rcpr_mobile='" + rcpr_mobile + '\'' +
                ", main_addr='" + main_addr + '\'' +
                ", detail_addr='" + detail_addr + '\'' +
                ", msg='" + msg + '\'' +
                ", pay_num='" + pay_num + '\'' +
                ", pay_state='" + pay_state + '\'' +
                ", card_appv_num=" + card_appv_num +
                ", card_cncl_num=" + card_cncl_num +
                ", mtd_code='" + mtd_code + '\'' +
                '}';
    }
}
