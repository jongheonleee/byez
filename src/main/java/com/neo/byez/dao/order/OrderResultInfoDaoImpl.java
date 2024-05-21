package com.neo.byez.dao.order;

import com.neo.byez.dao.order.OrderResultInfoDao;
import com.neo.byez.domain.order.OrderResultInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderResultInfoDaoImpl implements OrderResultInfoDao {

    @Autowired SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.OrderResultInfoDao.";

    // 주문내역 조회 SELECT 문

    // 주문번호, 주문일자, 주문금액, 배송비, 배송정보, 배송지 정보(ALL), 최종 결제 정보(ALL)
    @Override
    public OrderResultInfoDto selectOrderInfo(String ord_num) throws Exception {
        return session.selectOne(namespace + "selectOrderInfo", ord_num);
    }

    // ord_detail & ord 테이블 JOIN(+)
    // 상품정보(상품명, 옵션1: 사이즈, 옵션2: 색상), 수량, 주문금액, 주문상태
    @Override
    public List<OrderResultInfoDto> selectOrderedItemInfo(String ord_num) throws Exception {
        return session.selectList(namespace + "selectOrderedItemInfo", ord_num);
    }
}