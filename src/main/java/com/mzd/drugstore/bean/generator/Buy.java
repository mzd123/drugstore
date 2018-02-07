package com.mzd.drugstore.bean.generator;

public class Buy {
    private String buyid;

    private String userid;

    private String productid;

    private String createtime;

    public String getBuyid() {
        return buyid;
    }

    public void setBuyid(String buyid) {
        this.buyid = buyid == null ? null : buyid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}