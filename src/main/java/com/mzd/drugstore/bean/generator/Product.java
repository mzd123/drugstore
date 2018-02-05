package com.mzd.drugstore.bean.generator;

public class Product {
    private String productId;

    private String productName;

    private String productPrice;

    private String productImg;

    private String productDescription;

    private String productCreatetime;

    private String productStatus;

    private String productIfactivity;

    private String productNumber;

    private String productMonthbuy;

    private String classId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice == null ? null : productPrice.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    public String getProductCreatetime() {
        return productCreatetime;
    }

    public void setProductCreatetime(String productCreatetime) {
        this.productCreatetime = productCreatetime == null ? null : productCreatetime.trim();
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus == null ? null : productStatus.trim();
    }

    public String getProductIfactivity() {
        return productIfactivity;
    }

    public void setProductIfactivity(String productIfactivity) {
        this.productIfactivity = productIfactivity == null ? null : productIfactivity.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getProductMonthbuy() {
        return productMonthbuy;
    }

    public void setProductMonthbuy(String productMonthbuy) {
        this.productMonthbuy = productMonthbuy == null ? null : productMonthbuy.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}