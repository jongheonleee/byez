package com.neo.byez.domain.item;

import java.util.List;

public class LikeItemDtos {

    private List<LikeItemDto> list;

    public List<LikeItemDto> getList() {
        return list;
    }

    public void setList(List<LikeItemDto> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LikeItemDtos{" +
                "list=" + list +
                '}';
    }
}
