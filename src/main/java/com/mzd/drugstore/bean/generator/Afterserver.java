package com.mzd.drugstore.bean.generator;

public class Afterserver {
    private String afterserverId;

    private String afterserverClass;

    private String userId;

    private String orderId;

    private String afterserverCreatetime;

    private String afterserverStage;

    private String afterserverImg;

    private String afterserverClasses;

    public String getAfterserverId() {
        return afterserverId;
    }

    public void setAfterserverId(String afterserverId) {
        this.afterserverId = afterserverId == null ? null : afterserverId.trim();
    }

    public String getAfterserverClass() {
        return afterserverClass;
    }

    public void setAfterserverClass(String afterserverClass) {
        this.afterserverClass = afterserverClass == null ? null : afterserverClass.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getAfterserverCreatetime() {
        return afterserverCreatetime;
    }

    public void setAfterserverCreatetime(String afterserverCreatetime) {
        this.afterserverCreatetime = afterserverCreatetime == null ? null : afterserverCreatetime.trim();
    }

    public String getAfterserverStage() {
        return afterserverStage;
    }

    public void setAfterserverStage(String afterserverStage) {
        this.afterserverStage = afterserverStage == null ? null : afterserverStage.trim();
    }

    public String getAfterserverImg() {
        return afterserverImg;
    }

    public void setAfterserverImg(String afterserverImg) {
        this.afterserverImg = afterserverImg == null ? null : afterserverImg.trim();
    }

    public String getAfterserverClasses() {
        return afterserverClasses;
    }

    public void setAfterserverClasses(String afterserverClasses) {
        this.afterserverClasses = afterserverClasses == null ? null : afterserverClasses.trim();
    }
}