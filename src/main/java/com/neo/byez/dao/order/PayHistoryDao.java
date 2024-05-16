package com.neo.byez.dao.order;


import com.neo.byez.domain.order.PayHistoryDto;

import java.util.List;

public interface PayHistoryDao {
    int count() throws Exception;
    int insert(PayHistoryDto payHistoryDto) throws Exception;
    List<PayHistoryDto> select(String pay_num) throws Exception;
    int update(PayHistoryDto payHistoryDto) throws Exception;
    int delete(String pay_num) throws Exception;
    int deleteAll() throws Exception;
}
