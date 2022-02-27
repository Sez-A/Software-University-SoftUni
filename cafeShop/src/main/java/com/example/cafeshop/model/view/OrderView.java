package com.example.cafeshop.model.view;

import com.example.cafeshop.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class OrderView {
    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryNameEnum category;

    public Long getId() {
        return id;
    }

    public OrderView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderView setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
