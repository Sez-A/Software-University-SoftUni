package com.example.coffeShop.model.binding;

import com.example.coffeShop.model.entity.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderBindingModel {
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryNameEnum category;
    private String description;

    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public AddOrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public AddOrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public AddOrderBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public AddOrderBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public AddOrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
