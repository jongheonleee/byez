package com.neo.byez.dao.order;

import com.neo.byez.domain.order.PayHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayHistoryDaoImpl implements PayHistoryDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.PayHistoryDao.";
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int insert(PayHistoryDto payHistoryDto) throws Exception {
        return session.insert(namespace + "insert", payHistoryDto);
    }

    @Override
    public List<PayHistoryDto> select(String pay_num) throws Exception {
        return session.selectList(namespace + "select", pay_num);
    }

    @Override
    public int update(PayHistoryDto payHistoryDto) throws Exception {
        return session.update(namespace + "update", payHistoryDto);
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
