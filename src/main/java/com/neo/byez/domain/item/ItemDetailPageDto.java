package com.neo.byez.domain.item;

import java.util.Arrays;
import java.util.List;

public class ItemDetailPageDto {
    private String num;
    private String name;
    private String detail_name;
    private String cust_type;
    private Integer price;
    private Integer disc_price;
    private double disc_rate;
    private String col;
    private String size;
    private String detail_img;
    private String mfg_corp;
    private String mfg_name;
    private String mfg_date;
    private String model;
    private String origin;
    private String matr;
    private String caut;

    public ItemDetailPageDto() {}

    public ItemDetailPageDto(String num, String name, String detail_name, String cust_type,
            Integer price, Integer disc_price, double disc_rate, String col, String size,
            String detail_img, String mfg_corp, String mfg_name, String mfg_date, String model,
            String origin, String matr, String caut) {
        this.num = num;
        this.name = name;
        this.detail_name = detail_name;
        this.cust_type = cust_type;
        this.price = price;
        this.disc_price = disc_price;
        this.disc_rate = disc_rate;
        this.col = col; // 따로 조회해서 넣어주기
        this.size = size; // 따로 조회해서 넣어주기
        this.detail_img = detail_img;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail_name() {
        return detail_name;
    }

    public void setDetail_name(String detail_name) {
        this.detail_name = detail_name;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDisc_price() {
        return disc_price;
    }

    public void setDisc_price(Integer disc_price) {
        this.disc_price = disc_price;
    }

    public double getDisc_rate() {
        return disc_rate;
    }

    public void setDisc_rate(double disc_rate) {
        this.disc_rate = disc_rate;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDetail_img() {
        return detail_img;
    }

    public void setDetail_img(String detail_img) {
        this.detail_img = detail_img;
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

    public void setMfg_date(String mfg_Date) {
        this.mfg_date = mfg_Date;
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

    public List<String> getColors() {
        String[] colors = col.split(",");
        return Arrays.asList(colors);
    }

    public List<String> getSizes() {
        String[] sizes = size.split(",");
        return Arrays.asList(sizes);
    }


    @Override
    public String toString() {
        return "ItemDetailPageDto{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", detail_name='" + detail_name + '\'' +
                ", cust_type='" + cust_type + '\'' +
                ", price=" + price +
                ", disc_price=" + disc_price +
                ", disc_rate=" + disc_rate +
                ", col='" + col + '\'' +
                ", size='" + size + '\'' +
                ", detail_img='" + detail_img + '\'' +
                ", mfg_corp='" + mfg_corp + '\'' +
                ", mfg_name='" + mfg_name + '\'' +
                ", mfg_date='" + mfg_date + '\'' +
                ", model='" + model + '\'' +
                ", origin='" + origin + '\'' +
                ", matr='" + matr + '\'' +
                ", caut='" + caut + '\'' +
                '}';
    }
}
