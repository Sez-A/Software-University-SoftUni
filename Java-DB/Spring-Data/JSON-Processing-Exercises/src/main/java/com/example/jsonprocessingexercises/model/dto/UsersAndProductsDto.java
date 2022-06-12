package com.example.jsonprocessingexercises.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersAndProductsDto {
    @Expose
    private Integer usersCount;
    @Expose
    private List<UsersWithSoldProductsDto> users;

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UsersWithSoldProductsDto> getUsersWithSoldProducts() {
        return users;
    }

    public void setUsersWithSoldProducts(List<UsersWithSoldProductsDto> usersWithSoldProducts) {
        this.users = usersWithSoldProducts;
    }
}
