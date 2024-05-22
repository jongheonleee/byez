package com.neo.byez.dao.item;


import com.neo.byez.domain.item.BasketItemDto;
import java.util.List;

public interface BasketItemDao {
    int count(BasketItemDto dto) throws Exception;
    BasketItemDto get(BasketItemDto dto) throws Exception;

    BasketItemDto selectByContent(BasketItemDto dto) throws Exception;
    List<BasketItemDto> getList(BasketItemDto dto) throws Exception;
    int insert(BasketItemDto dto) throws Exception;
    int delete(BasketItemDto dto) throws Exception;
    int deleteByContent(BasketItemDto dto) throws Exception;
    int deleteAll(BasketItemDto dto) throws Exception;
    int update(BasketItemDto dto) throws Exception;
}
