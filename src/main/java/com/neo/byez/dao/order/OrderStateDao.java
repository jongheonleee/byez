package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrderStateDto;

import java.util.List;

public interface OrderStateDao {
    int count(String ord_num) throws Exception;
    int countAll() throws Exception;
    int insert(OrderStateDto orderStateDto) throws Exception;
    List<OrderStateDto> select(String ord_num) throws Exception;
    List<OrderStateDto> selectAll() throws Exception;
    int update(OrderStateDto orderStateDto) throws Exception;
    int delete(String ord_num) throws Exception;
    int deleteAll() throws Exception;
}
