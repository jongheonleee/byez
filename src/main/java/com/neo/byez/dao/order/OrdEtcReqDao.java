package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrdEtcReqDto;

public interface OrdEtcReqDao {
    int getCount();

    int insertCancel(OrdEtcReqDto ordEtcReqDto);

    void deleteAll();

    int insertRefund(OrdEtcReqDto ordEtcReqDto);
}
