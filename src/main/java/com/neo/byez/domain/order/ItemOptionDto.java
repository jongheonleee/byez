package com.neo.byez.domain.order;

import java.util.Objects;

public class ItemOptionDto {
    String item_num;
    String name;
    String color;
    String size;

    public ItemOptionDto(){
    }

    public ItemOptionDto(String item_num, String name, String color, String size) {
        this.item_num = item_num;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public ItemOptionDto(String item_num, String name, String color) {
        this.item_num = item_num;
        this.name = name;
        this.color = color;
    }

    public String getNum() {
        return item_num;
    }

    public void setNum(String item_num) {
        this.item_num = item_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOptionDto that = (ItemOptionDto) o;
        return Objects.equals(item_num, that.item_num) && Objects.equals(name, that.name) && Objects.equals(color, that.color) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_num, name, color, size);
    }

    @Override
    public String toString() {
        return "ItemOptionDto{" +
                "item_num='" + item_num + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
