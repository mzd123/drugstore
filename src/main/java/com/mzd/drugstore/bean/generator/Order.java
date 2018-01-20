package com.mzd.drugstore.bean.generator;

public class Order {
    private String orderId;

    private String orderSummoney;

    private String orderStage;

    private String orderCreatetime;

    private String orderOrigin;

    private String userId;

    private String addressId;

    private String orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderSummoney() {
        return orderSummoney;
    }

    public void setOrderSummoney(String orderSummoney) {
        this.orderSummoney = orderSummoney == null ? null : orderSummoney.trim();
    }

    public String getOrderStage() {
        return orderStage;
    }

    public void setOrderStage(String orderStage) {
        this.orderStage = orderStage == null ? null : orderStage.trim();
    }

    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(String orderCreatetime) {
        this.orderCreatetime = orderCreatetime == null ? null : orderCreatetime.trim();
    }

    public String getOrderOrigin() {
        return orderOrigin;
    }

    public void setOrderOrigin(String orderOrigin) {
        this.orderOrigin = orderOrigin == null ? null : orderOrigin.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }
}