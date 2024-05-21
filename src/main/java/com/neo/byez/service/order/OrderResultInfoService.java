package com.neo.byez.service.order;

import com.neo.byez.domain.order.OrderResultInfoDto;

import java.util.List;

public interface OrderResultInfoService {
//    public OrderResultInfoDto printOrderInfoList(String ord_num) throws Exception;

    // 주문번호, 주문일자, 주문금액, 배송비, 배송정보, 배송지 정보(ALL), 최종 결제 정보(ALL)
    public OrderResultInfoDto getOrderResultInfo(String ord_num);

    // 상품정보(상품명, 옵션1: 사이즈, 옵션2: 색상), 수량, 주문금액, 주문상태
    public List<OrderResultInfoDto> getOrderedItemList(String ord_num);
}