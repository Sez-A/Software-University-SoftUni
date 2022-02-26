package com.example.cafeshop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {
    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private Category category;
    private User employee;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Orders setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Orders setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Orders setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Orders setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Orders setCategory(Category category) {
        this.category = category;
        return this;
    }

    @ManyToOne
    public User getEmployee() {
        return employee;
    }

    public Orders setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
