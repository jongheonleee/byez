package com.neo.byez.domain.item;

public class OrderItemDto {


    private String num;

    private int qty;

    private String name;

    private int price;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    @Override
    public String toString() {
        return "OrderPageItemDto{" +
                "num='" + num + '\'' +
                ", qty=" + qty +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
