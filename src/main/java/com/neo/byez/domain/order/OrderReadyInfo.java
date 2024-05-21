package com.neo.byez.domain.order;

import java.util.List;

public class OrderReadyInfo {
    OrderDto orderDto;
    List<OrderDetailDto> orderDetailDtoList;
    OrderStateDto orderStateDto;
    PayDto payDto;
    PayStateDto payStateDto;
    DeliveryDto deliveryDto;


    // 주문명을 만든다 (ex. 상의 외 2건)
    public String makeOrderName(){
        String itemName = orderDetailDtoList.get(0).getItem_name();
        int size = orderDetailDtoList.size();
        if(size == 1){
            return itemName;
        }
        return size < 2 ? itemName : (itemName+" 외 "+(size - 1)+"건");
    }

    // 주문정보 초기화
    public void initOrderReadyInfo(String id, String ord_state, String pay_state){
        // 주문 초기화
        this.orderDto.setSaveReadyInfo(id);
        // 주문번호
        String ord_num = this.orderDto.getOrd_num();

        // 주문상품목록 초기화
        for(OrderDetailDto orderDetailDto : this.orderDetailDtoList){
            orderDetailDto.setSaveReadyInfo(ord_num, id, ord_state);
        }
        // 주문 상태 초기화
        this.orderStateDto.setSaveReadyInfo(id, 1, ord_num, ord_state);

        // 결제 초기화
        this.payDto.setSaveReadyInfo(ord_num, id, pay_state);
        // 결제번호
        String pay_num = this.payDto.getPay_num();

        // 결제 상태 초기화
        this.payStateDto.setSaveReadyInfo(id, 1, pay_num, pay_state);
        // 배송 초기화
        this.deliveryDto.setSaveReadyInfo(ord_num, id);
    }

    public OrderReadyInfo(){}

    public OrderReadyInfo(OrderDto orderDto, List<OrderDetailDto> orderDetailDtoList, OrderStateDto orderStateDto, PayDto payDto, PayStateDto payStateDto, DeliveryDto deliveryDto) {
        this.orderDto = orderDto;
        this.orderDetailDtoList = orderDetailDtoList;
        this.orderStateDto = orderStateDto;
        this.payDto = payDto;
        this.payStateDto = payStateDto;
        this.deliveryDto = deliveryDto;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public List<OrderDetailDto> getOrderDetailDtoList() {
        return orderDetailDtoList;
    }

    public void setOrderDetailDtoList(List<OrderDetailDto> orderDetailDtoList) {
        this.orderDetailDtoList = orderDetailDtoList;
    }

    public OrderStateDto getOrderStateDto() {
        return orderStateDto;
    }

    public void setOrderStateDto(OrderStateDto orderStateDto) {
        this.orderStateDto = orderStateDto;
    }

    public PayDto getPayDto() {
        return payDto;
    }

    public void setPayDto(PayDto payDto) {
        this.payDto = payDto;
    }

    public PayStateDto getPayStateDto() {
        return payStateDto;
    }

    public void setPayStateDto(PayStateDto payStateDto) {
        this.payStateDto = payStateDto;
    }

    public DeliveryDto getDeliveryDto() {
        return deliveryDto;
    }

    public void setDeliveryDto(DeliveryDto deliveryDto) {
        this.deliveryDto = deliveryDto;
    }

    @Override
    public String toString() {
        return "OrderReadyInfo{" +
                "\n orderDto=" + orderDto +
                ",\n orderDetailDtoList=" + orderDetailDtoList +
                ",\n orderStateDto=" + orderStateDto +
                ",\n payDto=" + payDto +
                ",\n payStateDto=" + payStateDto +
                ",\n deliveryDto=" + deliveryDto +
                "\n}";
    }
}
