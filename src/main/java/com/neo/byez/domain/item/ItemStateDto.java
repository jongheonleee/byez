package com.neo.byez.domain.item;

import java.util.Date;

public class ItemStateDto {

    private String num;
    private int sales_qty;
    private int view_cnt;
    private int stock_qty;
    private String state_code;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public ItemStateDto() {}

    public ItemStateDto(String num, int sales_qty, int view_cnt, int stock_qty, String state_code,
            Date reg_date, String reg_id, Date up_date, String up_id) {
        this.num = num;
        this.sales_qty = sales_qty;
        this.view_cnt = view_cnt;
        this.stock_qty = stock_qty;
        this.state_code = state_code;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getSales_qty() {
        return sales_qty;
    }

    public void setSales_qty(int sales_qty) {
        this.sales_qty = sales_qty;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getState_cede() {
        return state_code;
    }

    public void setState_cede(String state_code) {
        this.state_code = state_code;
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
}
