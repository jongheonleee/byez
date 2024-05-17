package com.neo.byez.service.order;

import com.neo.byez.domain.order.*;

import java.util.List;

public interface OrdEtcReqService {

    //1. 주문취소정보 삽입
    public boolean insertCancelInfo(OrdEtcReqDto ordEtcReqDto, OrderDetailDto orderDetailDto , OrderDto orderDto, OrderStateDto orderStateDto) throws Exception;
//    public int updateCnt(OrderDetailDto OrderDetailDto) throws Exception;
    public boolean insertRefundInfo(OrdEtcReqDto ordEtcReqDto,  OrderDetailDto orderDetailDto , OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception;
    public boolean confirmPurchase(OrderDto orderDto, OrderDetailDto orderDetailDto, OrderStateDto orderStateDto) throws Exception;
    public boolean insertExchangeInfo(OrdEtcReqDto ordEtcReqDto, OrderDetailDto orderDetailDto, OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception;


    //insertCancelInfo메서드를 분리해 값이 잘 저장되는지 확인하기 위함
    public int insertCancel(OrdEtcReqDto ordEtcReqDto);
    public int updateStateCode(OrderDto orderDto) throws Exception;
    public int insertOrderState(OrderStateDto orderStateDto) throws Exception;
    public int updateOrdState(OrderDetailDto orderDetailDto) throws Exception;
    public List<DeliveryDto> selectByOrdNum(String ord_num);
    public int insertRefundDlvInfo(DeliveryDto deliveryDto);

}
