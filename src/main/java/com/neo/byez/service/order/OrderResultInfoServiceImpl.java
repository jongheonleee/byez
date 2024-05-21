package com.neo.byez.service.order;

import com.neo.byez.dao.order.OrderResultInfoDaoImpl;
import com.neo.byez.domain.order.OrderResultInfoDto;
import com.neo.byez.service.order.OrderResultInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderResultInfoServiceImpl implements OrderResultInfoService {
    private OrderResultInfoDaoImpl orderResultInfoDao;

    @Autowired
    public OrderResultInfoServiceImpl(OrderResultInfoDaoImpl orderResultInfoDao) {
        this.orderResultInfoDao = orderResultInfoDao;
    }

    // 주문번호, 주문일자, 주문금액, 배송비, 배송정보, 배송지 정보(ALL), 최종 결제 정보(ALL)
    @Override
    public OrderResultInfoDto getOrderResultInfo(String ord_num) {
        OrderResultInfoDto orderResultInfoDto = null;
        try {
            orderResultInfoDto = orderResultInfoDao.selectOrderInfo(ord_num);
        } catch (Exception e) {
            e.printStackTrace();
            return orderResultInfoDto;
        }

        return orderResultInfoDto;
    }

    // 상품정보(상품명, 옵션1: 사이즈, 옵션2: 색상), 수량, 주문금액, 주문상태
    @Override
    public List<OrderResultInfoDto> getOrderedItemList(String ord_num) {
        List<OrderResultInfoDto> orderedItemList = null;
        try {
            orderedItemList = orderResultInfoDao.selectOrderedItemInfo(ord_num);
        } catch(Exception e) {
            e.printStackTrace();
            return orderedItemList;
        }

        return orderedItemList;
    }
}