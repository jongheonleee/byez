package com.neo.byez.domain.item;

public class ItemRegisterInfo {
    private String num;
    private String name;
    private int price;
    private int disc_price;
    private String main_img;
    private String item_type;
    private int review_cnt;
    private int like_cnt;
    private double review_rate;
    private String cust_type;
    private double disc_rate;
    private int period;
    private String size;
    private String col;
    private String remark;
    private String detail_name;
    private String comt;
    private String detail_img;
    private String rel_date;
    private String gr_date;
    private String mfg_corp;
    private String mfg_date;
    private int view_cnt;
    private String model;
    private int stock_qty;
    private String origin;
    private String state_code;
    private String matr;
    private String code;

    public ItemRegisterInfo() {
    }

    public ItemRegisterInfo(String name, int price, int disc_price, String main_img,
            String item_type,
            int review_cnt, int like_cnt, double review_rate, String cust_type, double disc_rate,
            int period, String size, String col, String remark, String detail_name, String comt,
            String detail_img, String rel_date, String gr_date, String mfg_corp, String mfg_date,
            int view_cnt, String model, int stock_qty, String origin, String state_code,
            String matr,
            String code) {
        this.name = name;
        this.price = price;
        this.disc_price = disc_price;
        this.main_img = main_img;
        this.item_type = item_type;
        this.review_cnt = review_cnt;
        this.like_cnt = like_cnt;
        this.review_rate = review_rate;
        this.cust_type = cust_type;
        this.disc_rate = disc_rate;
        this.period = period;
        this.size = size;
        this.col = col;
        this.remark = remark;
        this.detail_name = detail_name;
        this.comt = comt;
        this.detail_img = detail_img;
        this.rel_date = rel_date;
        this.gr_date = gr_date;
        this.mfg_corp = mfg_corp;
        this.mfg_date = mfg_date;
        this.view_cnt = view_cnt;
        this.model = model;
        this.stock_qty = stock_qty;
        this.origin = origin;
        this.state_code = state_code;
        this.matr = matr;
        this.code = code;
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

    public int getDisc_price() {
        return disc_price;
    }

    public void setDisc_price(int disc_price) {
        this.disc_price = disc_price;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getReview_cnt() {
        return review_cnt;
    }

    public void setReview_cnt(int review_cnt) {
        this.review_cnt = review_cnt;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public double getReview_rate() {
        return review_rate;
    }

    public void setReview_rate(double review_rate) {
        this.review_rate = review_rate;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public double getDisc_rate() {
        return disc_rate;
    }

    public void setDisc_rate(double disc_rate) {
        this.disc_rate = disc_rate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDetail_name() {
        return detail_name;
    }

    public void setDetail_name(String detail_name) {
        this.detail_name = detail_name;
    }

    public String getComt() {
        return comt;
    }

    public void setComt(String comt) {
        this.comt = comt;
    }

    public String getDetail_img() {
        return detail_img;
    }

    public void setDetail_img(String detail_img) {
        this.detail_img = detail_img;
    }

    public String getRel_date() {
        return rel_date;
    }

    public void setRel_date(String rel_date) {
        this.rel_date = rel_date;
    }

    public String getGr_date() {
        return gr_date;
    }

    public void setGr_date(String gr_date) {
        this.gr_date = gr_date;
    }

    public String getMfg_corp() {
        return mfg_corp;
    }

    public void setMfg_corp(String mfg_corp) {
        this.mfg_corp = mfg_corp;
    }

    public String getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(String mfg_date) {
        this.mfg_date = mfg_date;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
