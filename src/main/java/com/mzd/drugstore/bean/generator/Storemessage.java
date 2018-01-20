package com.mzd.drugstore.bean.generator;

public class Storemessage {
    private String storeName;

    private String storeLocation;

    private String storeImg;

    private String storeTel;

    private String bossName;

    private String bossTel;

    private String bossIdcard;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation == null ? null : storeLocation.trim();
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg == null ? null : storeImg.trim();
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel == null ? null : storeTel.trim();
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public String getBossTel() {
        return bossTel;
    }

    public void setBossTel(String bossTel) {
        this.bossTel = bossTel == null ? null : bossTel.trim();
    }

    public String getBossIdcard() {
        return bossIdcard;
    }

    public void setBossIdcard(String bossIdcard) {
        this.bossIdcard = bossIdcard == null ? null : bossIdcard.trim();
    }
}