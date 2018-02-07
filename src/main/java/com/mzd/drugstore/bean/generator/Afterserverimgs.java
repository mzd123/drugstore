package com.mzd.drugstore.bean.generator;

public class Afterserverimgs {
    private String imgid;

    private String afterserverid;

    private String imgpath;

    private String imgStatus;

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid == null ? null : imgid.trim();
    }

    public String getAfterserverid() {
        return afterserverid;
    }

    public void setAfterserverid(String afterserverid) {
        this.afterserverid = afterserverid == null ? null : afterserverid.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(String imgStatus) {
        this.imgStatus = imgStatus == null ? null : imgStatus.trim();
    }
}