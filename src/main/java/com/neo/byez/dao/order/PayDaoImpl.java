package com.neo.byez.dao.order;

import com.neo.byez.domain.order.PayDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PayDaoImpl implements PayDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.PayDao.";
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(PayDto payDto) throws Exception {
        return session.insert(namespace + "insert", payDto);
    }

    @Override
    public PayDto select(String pay_num) throws Exception {
        return session.selectOne(namespace + "select", pay_num);
    }

    @Override
    public int update(PayDto payDto) throws Exception {
        return session.update(namespace + "update", payDto);
    }

    @Override
    public int delete(String pay_num) throws Exception {
        return session.delete(namespace + "delete", pay_num);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
