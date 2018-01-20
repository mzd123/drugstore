package com.mzd.drugstore.bean.generator;

public class Productclass {
    private String productclassId;

    private String productclassName;

    public String getProductclassId() {
        return productclassId;
    }

    public void setProductclassId(String productclassId) {
        this.productclassId = productclassId == null ? null : productclassId.trim();
    }

    public String getProductclassName() {
        return productclassName;
    }

    public void setProductclassName(String productclassName) {
        this.productclassName = productclassName == null ? null : productclassName.trim();
    }
}