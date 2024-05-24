package com.neo.byez.service.order;

import com.neo.byez.domain.order.*;

import javax.servlet.http.HttpSession;

public interface OrdEtcReqService {

    //1. 주문취소정보 삽입
     boolean insertCancelInfo(HttpSession session, OrdEtcReqDto ordEtcReqDto, OrderDetailDto orderDetailDto , OrderDto orderDto, OrderStateDto orderStateDto) throws Exception;
    //     int updateCnt(OrderDetailDto OrderDetailDto) throws Exception;
     boolean insertRefundInfo(HttpSession session, OrdEtcReqDto ordEtcReqDto,  OrderDetailDto orderDetailDto , OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception;
     boolean confirmPurchase(OrderDto orderDto, OrderDetailDto orderDetailDto, OrderStateDto orderStateDto) throws Exception;
     boolean insertExchangeInfo(HttpSession session, OrdEtcReqDto ordEtcReqDto, OrderDetailDto orderDetailDto, OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception;


    //insertCancelInfo메서드를 분리해 값이 잘 저장되는지 확인하기 위함
     int insertCancel(OrdEtcReqDto ordEtcReqDto);
     int updateStateCode(OrderDto orderDto) throws Exception;
     int insertOrderState(OrderStateDto orderStateDto) throws Exception;
     int updateOrdState(OrderDetailDto orderDetailDto) throws Exception;
     DeliveryDto selectByOrdNum(String ord_num);
     int insertRefundDlvInfo(DeliveryDto deliveryDto);
}
