package com.neo.byez.dao.order;


import com.neo.byez.domain.order.PayDto;

public interface PayDao {
    int count() throws Exception;
    int insert(PayDto payDto) throws Exception;
    PayDto select(String pay_num) throws Exception;
    int update(PayDto payDto) throws Exception;
    int delete(String pay_num) throws Exception;
    int deleteAll() throws Exception;
}
