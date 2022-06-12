package com.example.jsonprocessingexercises.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoriesByProductsCountDto {
    @Expose
    private String name;
    @Expose
    private Integer productCount;
    @Expose
    private String averagePrice;
    @Expose
    private String totalPrice;

    public CategoriesByProductsCountDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
