package com.example.coffeShop.model.view;

public class EmployeeView {
    private Long id;
    private String username;
    private Integer numberOfOrders;

    public Long getId() {
        return id;
    }

    public EmployeeView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EmployeeView setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public EmployeeView setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
        return this;
    }
}
