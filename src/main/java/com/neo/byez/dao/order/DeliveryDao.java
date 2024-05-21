package com.neo.byez.dao.order;

import com.neo.byez.domain.order.DeliveryDto;

import java.util.List;

public interface DeliveryDao {
    int count() throws Exception;
    int insert(DeliveryDto deliveryDto) throws Exception;
    DeliveryDto select(String dlv_num) throws Exception;
    int update(DeliveryDto deliveryDto) throws Exception;
    int delete(String dlv_num) throws Exception;
    int deleteAll() throws Exception;
     int insertRefundDlvInfo(DeliveryDto deliveryDto);
    DeliveryDto selectByOrdNum(String ord_num);
    List<DeliveryDto> selectAll();
    int countByOrdNum(String ord_num);

}
