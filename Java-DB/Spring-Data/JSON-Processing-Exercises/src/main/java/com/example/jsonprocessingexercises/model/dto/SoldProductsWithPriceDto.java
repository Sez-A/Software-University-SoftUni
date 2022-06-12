package com.example.jsonprocessingexercises.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SoldProductsWithPriceDto {
    @Expose
    private Integer count;
    @Expose
    private List<ProductWithNameAndPriceDto> products;

    public SoldProductsWithPriceDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductWithNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithNameAndPriceDto> products) {
        this.products = products;
    }
}
