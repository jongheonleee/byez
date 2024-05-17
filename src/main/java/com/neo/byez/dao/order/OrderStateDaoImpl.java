package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderStateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStateDaoImpl implements OrderStateDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.OrderStateDao.";

    @Override
    public int count(String ord_num) throws Exception {
        return session.selectOne(namespace + "count", ord_num);
    }

    @Override
    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }

    @Override
    public int insert(OrderStateDto orderStateDto) throws Exception {
        return session.insert(namespace + "insert", orderStateDto);
    }

    @Override
    public List<OrderStateDto> select(String ord_num) throws Exception {
        return session.selectList(namespace + "select", ord_num);
    }

    @Override
    public List<OrderStateDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int update(OrderStateDto orderStateDto) throws Exception {
        return session.update(namespace + "update", orderStateDto);
    }

    @Override
    public int delete(String ord_num) throws Exception {
        return session.delete(namespace + "delete", ord_num);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int insertOrderState(OrderStateDto orderStateDto) throws Exception {
        return session.insert(namespace + "insertOrderState", orderStateDto);
    }
}
