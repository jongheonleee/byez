package com.neo.byez.dao.order;


import com.neo.byez.domain.order.DeliveryDto;

public interface DeliveryDao {
    int count() throws Exception;
    int insert(DeliveryDto deliveryDto) throws Exception;
    DeliveryDto select(String dlv_num) throws Exception;
    int update(DeliveryDto deliveryDto) throws Exception;
    int delete(String dlv_num) throws Exception;
    int deleteAll() throws Exception;
}
