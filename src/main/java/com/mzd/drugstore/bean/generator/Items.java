package com.mzd.drugstore.bean.generator;

public class Items {
    private String itemsId;

    private String productId;

    private String orderId;

    private String productNumber;

    private String userId;

    private String itemsMoney;

    private String itemsStatus;

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId == null ? null : itemsId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getItemsMoney() {
        return itemsMoney;
    }

    public void setItemsMoney(String itemsMoney) {
        this.itemsMoney = itemsMoney == null ? null : itemsMoney.trim();
    }

    public String getItemsStatus() {
        return itemsStatus;
    }

    public void setItemsStatus(String itemsStatus) {
        this.itemsStatus = itemsStatus == null ? null : itemsStatus.trim();
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemsId='" + itemsId + '\'' +
                ", productId='" + productId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", itemsMoney='" + itemsMoney + '\'' +
                ", itemsStatus='" + itemsStatus + '\'' +
                '}';
    }
}