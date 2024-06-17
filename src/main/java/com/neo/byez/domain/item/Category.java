package com.neo.byez.domain.item;

public class Category {

    private String cate_num;
    private String cate_name;
    private String col1;
    private String col2;
    public Category() {}

    public Category(String cate_num, String cate_name, String col1, String col2) {
        this.cate_num = cate_num;
        this.cate_name = cate_name;
        this.col1 = col1;
        this.col2 = col2;
    }

    public String getCate_num() {
        return cate_num;
    }

    public void setCate_num(String cate_num) {
        this.cate_num = cate_num;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }
}
