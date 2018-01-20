package com.mzd.drugstore.bean.generator;

public class Address {
    private String addressId;

    private String addressLocation;

    private String addressCreatetime;

    private String addressStatus;

    private String userid;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation == null ? null : addressLocation.trim();
    }

    public String getAddressCreatetime() {
        return addressCreatetime;
    }

    public void setAddressCreatetime(String addressCreatetime) {
        this.addressCreatetime = addressCreatetime == null ? null : addressCreatetime.trim();
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus == null ? null : addressStatus.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}