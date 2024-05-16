package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrderDetailDto;

import java.util.List;

public interface OrderDetailDao {
    int count(String ord_num) throws Exception;
    int countAll() throws Exception;
    int insert(OrderDetailDto orderDetailDto) throws Exception;
    List<OrderDetailDto> select(String ord_num) throws Exception;
    List<OrderDetailDto> selectAll(String id) throws Exception;
    int update(OrderDetailDto orderDetailDto) throws Exception;
    int delete(String ord_num) throws Exception;
    int deleteAll() throws Exception;
}
