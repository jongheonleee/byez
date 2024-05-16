package com.neo.byez.dao.order;


import com.neo.byez.domain.order.PayStateDto;

import java.util.List;

public interface PayStateDao {
    int count() throws Exception;
    int insert(PayStateDto payStateDto) throws Exception;
    List<PayStateDto> select(String pay_num) throws Exception;
    int update(PayStateDto payStateDto) throws Exception;
    int delete(String pay_num) throws Exception;
    int deleteAll() throws Exception;
}
