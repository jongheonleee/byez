package com.neo.byez.domain.item;

import java.util.ArrayList;
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

    public void addBasketItemDto(BasketItemDto dto) {
        if (orders == null) {
            orders = new ArrayList<>();
        }

        orders.add(dto);
    }
    @Override
    public String toString() {
        return "BasketItemDtos [orders=" + orders + "]";
    }

}
