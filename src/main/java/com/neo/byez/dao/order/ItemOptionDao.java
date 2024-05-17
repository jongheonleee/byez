package com.neo.byez.dao.order;

import com.neo.byez.domain.order.ItemOptionDto;

import java.util.List;

public interface ItemOptionDao {

    List<ItemOptionDto> selectColor(String num);

    List<ItemOptionDto> selectSize(String num);

    int getCountSize(String num);
    int getCountColor(String num);
}
