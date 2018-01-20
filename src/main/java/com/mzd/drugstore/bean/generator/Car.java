package com.mzd.drugstore.bean.generator;

public class Car {
    private String carId;

    private String carUserid;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarUserid() {
        return carUserid;
    }

    public void setCarUserid(String carUserid) {
        this.carUserid = carUserid == null ? null : carUserid.trim();
    }
}