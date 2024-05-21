package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrderDto;
import java.util.List;

public interface OrderDao {

    int count(String id) throws Exception;
    int countAll() throws Exception;
    int insert(OrderDto orderDto) throws Exception;
    OrderDto select(String ord_num) throws Exception;
    List<OrderDto> selectAll(String id) throws Exception;
    int update(OrderDto orderDto) throws Exception;
    int delete(String ord_num) throws Exception;
    int deleteAll() throws Exception;
    int updateStateCode(OrderDto orderDto) throws Exception;

}
