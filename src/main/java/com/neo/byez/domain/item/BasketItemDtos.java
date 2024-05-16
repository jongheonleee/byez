package com.neo.byez.domain.item;

import java.util.List;

public class BasketItemDtos {

    private List<BasketItemDto> orders;

    public List<BasketItemDto> getOrders() {
        return orders;
    }

    public BasketItemDtos() {}

    public void setOrders(List<BasketItemDto> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "BasketItemDtos [orders=" + orders + "]";
    }

}
