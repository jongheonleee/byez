package com.neo.byez.domain.item;

import java.util.List;

public class OrderItemDtos {

    private List<OrderItemDto> orders;

    public List<OrderItemDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItemDto> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderPageDTO [orders=" + orders + "]";
    }

}
