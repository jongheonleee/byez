package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrdEtcReqDto;

public interface OrdEtcReqDao {
    int getCount();

    int getCountOrdNum(String ord_num);

    int insertCancel(OrdEtcReqDto ordEtcReqDto);

    void deleteAll();

    int insertRefund(OrdEtcReqDto ordEtcReqDto);
}
