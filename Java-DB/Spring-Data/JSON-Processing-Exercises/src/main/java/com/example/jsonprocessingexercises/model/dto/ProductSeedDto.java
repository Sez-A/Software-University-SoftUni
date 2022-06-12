package com.example.jsonprocessingexercises.model.dto;

import com.example.jsonprocessingexercises.model.entity.Category;
import com.example.jsonprocessingexercises.model.entity.User;
import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

public class ProductSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    private User buyerId;
    private User sellerId;
    private Set<Category> categories;

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
