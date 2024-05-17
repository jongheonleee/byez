package com.neo.byez.dao.order;

import com.neo.byez.domain.order.DeliveryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryDaoImpl implements DeliveryDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.DeliveryDao.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(DeliveryDto deliveryDto) throws Exception {
        return session.insert(namespace + "insert", deliveryDto);
    }

    @Override
    public DeliveryDto select(String dlv_num) throws Exception {
        return session.selectOne(namespace + "select", dlv_num);
    }

    @Override
    public int update(DeliveryDto deliveryDto) throws Exception {
        return session.update(namespace + "update", deliveryDto);
    }

    @Override
    public int delete(String dlv_num) throws Exception {
        return session.delete(namespace + "delete", dlv_num);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int insertRefundDlvInfo(DeliveryDto deliveryDto) {
       return session.insert(namespace + "insertRefundDlvInfo", deliveryDto);
    }


    @Override
    public List<DeliveryDto> selectByOrdNum(String ord_num) {
        return session.selectList(namespace + "selectByOrdNum", ord_num);
    }

    @Override
    public List<DeliveryDto> selectAll() {
        return session.selectList(namespace + "selectAll");
    }
}
