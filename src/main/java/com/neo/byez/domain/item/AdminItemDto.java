package com.neo.byez.domain.item;

public class AdminItemDto {

    private String num;
    private String name;
    private String item_type;
    private String cust_type;
    private String state_code;
    private int price;
    private int disc_price;
    private double disc_rate;
    private int stock_qty;
    private String mfg_corp;
    private String mfg_name;
    private String rel_date;
    private String reg_date;
    private String up_date;


    public AdminItemDto() {
    }

    public AdminItemDto(String num, String name, String item_type, String cust_type,
            String state_code,
            int price, int disc_price, double disc_rate, int stock_qty, String mfg_corp,
            String mfg_name, String rel_date, String reg_date, String up_date) {
        this.num = num;
        this.name = name;
        this.item_type = item_type;
        this.cust_type = cust_type;
        this.state_code = state_code;
        this.price = price;
        this.disc_price = disc_price;
        this.disc_rate = disc_rate;
        this.stock_qty = stock_qty;
        this.mfg_corp = mfg_corp;
        this.mfg_name = mfg_name;
        this.rel_date = rel_date;
        this.reg_date = reg_date;
        this.up_date = up_date;
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

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
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

    public double getDisc_rate() {
        return disc_rate;
    }

    public void setDisc_rate(double disc_rate) {
        this.disc_rate = disc_rate;
    }

    public String getMfg_name() {
        return mfg_name;
    }

    public void setMfg_name(String mfg_name) {
        this.mfg_name = mfg_name;
    }

    public String getRel_date() {
        return rel_date;
    }

    public void setRel_date(String rel_date) {
        this.rel_date = rel_date;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getMfg_corp() {
        return mfg_corp;
    }

    public void setMfg_corp(String mfg_corp) {
        this.mfg_corp = mfg_corp;
    }

    @Override
    public String toString() {
        return "AdminItemDto{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", item_type='" + item_type + '\'' +
                ", cust_type='" + cust_type + '\'' +
                ", state_code='" + state_code + '\'' +
                ", price=" + price +
                ", disc_price=" + disc_price +
                ", disc_rate=" + disc_rate +
                ", stock_qty=" + stock_qty +
                ", mfg_corp='" + mfg_corp + '\'' +
                ", mfg_name='" + mfg_name + '\'' +
                ", rel_date='" + rel_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", up_date='" + up_date + '\'' +
                '}';
    }
}
