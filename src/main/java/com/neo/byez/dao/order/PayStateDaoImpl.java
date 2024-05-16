package com.neo.byez.dao.order;

import com.neo.byez.domain.order.PayStateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayStateDaoImpl implements PayStateDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.PayStateDao.";
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(PayStateDto payStateDto) throws Exception {
        return session.insert(namespace + "insert", payStateDto);
    }

    @Override
    public List<PayStateDto> select(String pay_num) throws Exception {
        return session.selectList(namespace + "select", pay_num);
    }

    @Override
    public int update(PayStateDto payStateDto) throws Exception {
        return session.update(namespace + "update", payStateDto);
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
