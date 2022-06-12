package com.example.jsonprocessingexercises.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class UsersWithSoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private SoldProductsWithPriceDto soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SoldProductsWithPriceDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsWithPriceDto soldProductsWithPrice) {
        this.soldProducts = soldProductsWithPrice;
    }
}
