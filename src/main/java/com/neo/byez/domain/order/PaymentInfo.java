package com.neo.byez.domain.order;

public class PaymentInfo {
    String orderId;
    String orderName;
    String successUrl;
    String failUrl;
    String customerEmail;
    String customerName;
    String customerMobilePhone;

    public PaymentInfo(OrderReadyInfo orderReadyInfo, String email, String name, String mobile){
//    public PaymentInfo(OrderDto orderDto, UserDto userDto){
//        this(orderDto.getOrd_num(), orderDto.getOrd_name(), "/success", "/fail", userDto.getEmail(), userDto.getName(), userDto.getMobile())
        this(orderReadyInfo.getOrderDto().getOrd_num(), orderReadyInfo.makeOrderName(), "/success", "/fail", email, name, mobile);
    }

    public PaymentInfo() {}

    public PaymentInfo(String orderId, String orderName, String successUrl, String failUrl, String customerEmail, String customerName, String customerMobilePhone) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.successUrl = successUrl;
        this.failUrl = failUrl;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerMobilePhone = customerMobilePhone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobilePhone() {
        return customerMobilePhone;
    }

    public void setCustomerMobilePhone(String customerMobilePhone) {
        this.customerMobilePhone = customerMobilePhone;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", failUrl='" + failUrl + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerMobilePhone='" + customerMobilePhone + '\'' +
                '}';
    }
}
