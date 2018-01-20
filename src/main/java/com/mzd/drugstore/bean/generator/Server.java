package com.mzd.drugstore.bean.generator;

public class Server {
    private String serverId;

    private String serverContent;

    private String orderId;

    private String afterserverId;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public String getServerContent() {
        return serverContent;
    }

    public void setServerContent(String serverContent) {
        this.serverContent = serverContent == null ? null : serverContent.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getAfterserverId() {
        return afterserverId;
    }

    public void setAfterserverId(String afterserverId) {
        this.afterserverId = afterserverId == null ? null : afterserverId.trim();
    }
}