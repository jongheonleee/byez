package com.neo.byez.dao.order;

import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.order.OrderResultInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.OrderDao.";

    @Override
    public OrderResultInfo selectOrderResult(String ord_num) throws Exception {
        return session.selectOne(namespace + "selectOrderResult", ord_num);
    }

    // ID에 해당하는 전체 주문 개수
    @Override
    public int count(String id) throws Exception {
        return session.selectOne(namespace + "count", id);
    }

    // 모든 주문 개수
    @Override
    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }

    // 하나의 주문 저장
    @Override
    public int insert(OrderDto orderDto) throws Exception {
        return session.insert(namespace + "insert", orderDto);
    }

    // 주문번호로 주문조회
    @Override
    public OrderDto select(String ord_num) throws Exception {
        return session.selectOne(namespace + "select", ord_num);
    }

    // ID에 해당하는 전체 주문 목록 조회
    @Override
    public List<OrderDto> selectAll(String id) throws Exception {
        return session.selectList(namespace + "selectAll", id);
    }

    // 하나의 주문정보 수정
    @Override
    public int update(OrderDto orderDto) throws Exception {
        return session.update(namespace + "update", orderDto);
    }

    // 주문번호로 하나의 주문 삭제
    @Override
    public int delete(String ord_num) throws Exception {
        return session.delete(namespace + "delete", ord_num);
    }

    //############### 추가 할 것
    // ID에 해당하는 전체 주문 목록 삭제

    // 테이블의 전체 주문 삭제
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int updateStateCode(OrderDto orderDto) throws Exception {
        return session.update(namespace + "updateStateCode", orderDto);
    }
}
