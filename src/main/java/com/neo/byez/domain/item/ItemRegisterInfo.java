package com.neo.byez.domain.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemRegisterInfo {
    private String num;
    private String name;
    private int price;
    private int disc_price;

    private String mfg_name;

    private int sales_qty;
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

    private String caut;

    public ItemRegisterInfo() {
    }

    public ItemRegisterInfo(String num, String name, int price, int disc_price, String main_img,
            String item_type,
            int review_cnt, int like_cnt, double review_rate, String cust_type, double disc_rate,
            int period, String size, String col, String remark, String detail_name, String comt,
            String detail_img, String rel_date, String gr_date, String mfg_corp, String mfg_date,
            int view_cnt, String model, int stock_qty, String origin, String state_code,
            String matr, String code, String caut, int sales_qty, String mfg_name) {
        this.num = num;
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
        this.caut = caut;
        this.sales_qty = sales_qty;
        this.mfg_name = mfg_name;
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

    public ItemDto getItemDto() {
        return new ItemDto(num, name, item_type, cust_type, price, disc_price, main_img, review_cnt, review_rate, like_cnt, col);
    }

    public ItemDetailDto getItemDetailDto() {
        return new ItemDetailDto(num, detail_name, comt, detail_img, price, rel_date, gr_date, mfg_corp, mfg_name, mfg_date, model,
                origin, matr, caut);
    }

    public ItemStateDto getItemStateDto() {
        return new ItemStateDto(num, sales_qty, view_cnt, stock_qty, state_code);
    }

    public List<ItemOptDto> getColorList() {
        List<ItemOptDto> list = new ArrayList<>();
        String[] cols = col.split(",");

        for (String parsedCol : cols) {
            list.add(new ItemOptDto(num, parsedCol));
        }

        return list;
    }

    public List<ItemOptDto> getSizeList() {
        List<ItemOptDto> list = new ArrayList<>();
        String[] sizes = size.split(",");

        for (String parsedSize : sizes) {
            list.add(new ItemOptDto(num, parsedSize));
        }

        return list;
    }

    public ItemPriceDto getItemPriceDto() {
        return new ItemPriceDto(num, disc_rate, period, remark);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMfg_name() {
        return mfg_name;
    }

    public void setMfg_name(String mfg_name) {
        this.mfg_name = mfg_name;
    }

    public int getSales_qty() {
        return sales_qty;
    }

    public void setSales_qty(int sales_qty) {
        this.sales_qty = sales_qty;
    }

    public String getCaut() {
        return caut;
    }

    public void setCaut(String caut) {
        this.caut = caut;
    }

    @Override
    public String toString() {
        return "ItemRegisterInfo{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", disc_price=" + disc_price +
                ", main_img='" + main_img + '\'' +
                ", item_type='" + item_type + '\'' +
                ", review_cnt=" + review_cnt +
                ", like_cnt=" + like_cnt +
                ", review_rate=" + review_rate +
                ", cust_type='" + cust_type + '\'' +
                ", disc_rate=" + disc_rate +
                ", period=" + period +
                ", size='" + size + '\'' +
                ", col='" + col + '\'' +
                ", remark='" + remark + '\'' +
                ", detail_name='" + detail_name + '\'' +
                ", comt='" + comt + '\'' +
                ", detail_img='" + detail_img + '\'' +
                ", rel_date='" + rel_date + '\'' +
                ", gr_date='" + gr_date + '\'' +
                ", mfg_corp='" + mfg_corp + '\'' +
                ", mfg_date='" + mfg_date + '\'' +
                ", view_cnt=" + view_cnt +
                ", model='" + model + '\'' +
                ", stock_qty=" + stock_qty +
                ", origin='" + origin + '\'' +
                ", state_code='" + state_code + '\'' +
                ", matr='" + matr + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
