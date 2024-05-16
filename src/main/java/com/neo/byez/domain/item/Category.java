package com.neo.byez.domain.item;

public class Category {

    private String item_type;
    private String item_type_format;

    public Category() {}

    public Category(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_type_format() {
        return item_type_format != null ? item_type_format : generateFormat();
    }

    private String generateFormat() {
        item_type_format = "%" + item_type;
        return item_type_format;
    }
}
