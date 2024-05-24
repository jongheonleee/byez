package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrdEtcReqDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdEtcReqDaoImpl implements OrdEtcReqDao {
    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.order.OrdEtcReqDao.";

    @Override
    public int getCount(){
        return session.selectOne(namespace + "count");
    }

    @Override
    public int getCountOrdNum(String ord_num) {
        return session.selectOne(namespace + "coundByOrdNum", ord_num);
    }

    @Override
    public int insertCancel(OrdEtcReqDto ordEtcReqDto){
        return session.insert(namespace + "insertCancel", ordEtcReqDto);
    }

    @Override
    public void deleteAll(){
        session.delete(namespace + "deleteAll");
    }

    @Override
    public int insertRefund(OrdEtcReqDto ordEtcReqDto) {
        return session.insert(namespace + "insertRefund", ordEtcReqDto);
    }

}
