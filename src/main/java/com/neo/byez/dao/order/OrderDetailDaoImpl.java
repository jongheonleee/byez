package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderDetailDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.OrderDetailDao.";

    @Override
    public int count(String ord_num) throws Exception {
        return session.selectOne(namespace + "count", ord_num);
    }

    @Override
    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }

    @Override
    public int insert(OrderDetailDto orderDetailDto) throws Exception {
        return session.insert(namespace + "insert", orderDetailDto);
    }

    @Override
    public List<OrderDetailDto> select(String ord_num) throws Exception {
        return session.selectList(namespace + "select", ord_num);
    }

    @Override
    public List<OrderDetailDto> selectAll(String id) throws Exception {
        return session.selectList(namespace + "selectAll", id);
    }

    @Override
    public int update(OrderDetailDto orderDetailDto) throws Exception {
        return session.update(namespace + "update", orderDetailDto);
    }

    @Override
    public int delete(String ord_num) throws Exception {
        return session.delete(namespace + "delete", ord_num);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
