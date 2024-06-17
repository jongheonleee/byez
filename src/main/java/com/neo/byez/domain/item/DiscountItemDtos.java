package com.neo.byez.domain.item;

import java.util.List;

public class DiscountItemDtos {

    private List<ItemDto> list;

    public DiscountItemDtos() {}

    public DiscountItemDtos(List<ItemDto> list) {
        this.list = list;
    }

    public void addDiscountItemDtos(List<ItemDto> list) {
        this.list.addAll(list);
    }

    public List<ItemDto> getDtos() {
        return list;
    }
}
