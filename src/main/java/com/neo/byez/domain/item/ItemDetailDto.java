package com.neo.byez.domain.item;

import java.util.Objects;

// 상세 페이지에서 활용
public class ItemDetailDto {
    private String num;
    private String detail_name;
    private String comt;
    private String detail_img;
    private int price;
    private String rel_date;
    private String gr_date;
    private String mfg_corp;
    private String mfg_name;
    private String mfg_date;
    private String model;
    private String origin;
    private String matr;
    private String caut;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public ItemDetailDto() {
    }

    public ItemDetailDto(String num, String detail_name, String comt, String detail_img, int price,
            String rel_date, String gr_date, String mfg_corp, String mfg_name, String mfg_date,
            String model, String origin, String matr, String caut, String reg_date, String reg_id,
            String up_date, String up_id) {
        this.num = num;
        this.detail_name = detail_name;
        this.comt = comt;
        this.detail_img = detail_img;
        this.price = price;
        this.rel_date = rel_date;
        this.gr_date = gr_date;
        this.mfg_corp = mfg_corp;
        this.mfg_name = mfg_name;
        this.mfg_date = mfg_date;
        this.model = model;
        this.origin = origin;
        this.matr = matr;
        this.caut = caut;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public ItemDetailDto(String num, String detail_name, String comt, String detail_img, int price,
            String rel_date, String gr_date, String mfg_corp, String mfg_name, String mfg_date,
            String model, String origin, String matr, String caut) {
        this.num = num;
        this.detail_name = detail_name;
        this.comt = comt;
        this.detail_img = detail_img;
        this.price = price;
        this.rel_date = rel_date;
        this.gr_date = gr_date;
        this.mfg_corp = mfg_corp;
        this.mfg_name = mfg_name;
        this.mfg_date = mfg_date;
        this.model = model;
        this.origin = origin;
        this.matr = matr;
        this.caut = caut;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getMfg_name() {
        return mfg_name;
    }

    public void setMfg_name(String mfg_name) {
        this.mfg_name = mfg_name;
    }

    public String getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(String mfg_date) {
        this.mfg_date = mfg_date;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getCaut() {
        return caut;
    }

    public void setCaut(String caut) {
        this.caut = caut;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemDetailDto that = (ItemDetailDto) o;
        return price == that.price && num.equals(that.num) && Objects.equals(detail_name,
                that.detail_name) && Objects.equals(comt, that.comt)
                && Objects.equals(detail_img, that.detail_img) && Objects.equals(
                mfg_corp, that.mfg_corp) && Objects.equals(mfg_name, that.mfg_name)
                && Objects.equals(model, that.model) && Objects.equals(origin,
                that.origin) && Objects.equals(matr, that.matr) && Objects.equals(
                caut, that.caut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, detail_name, comt, detail_img, price, mfg_corp, mfg_name, model,
                origin, matr, caut);
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }
}
