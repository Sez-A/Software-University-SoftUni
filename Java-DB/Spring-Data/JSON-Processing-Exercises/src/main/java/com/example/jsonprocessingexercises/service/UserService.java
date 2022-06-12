package com.example.jsonprocessingexercises.service;

import com.example.jsonprocessingexercises.model.dto.UserSeedDto;
import com.example.jsonprocessingexercises.model.dto.UsersAndProductsDto;
import com.example.jsonprocessingexercises.model.dto.UsersSoldProductsDto;
import com.example.jsonprocessingexercises.model.dto.UsersWithSoldProductsDto;
import com.example.jsonprocessingexercises.model.entity.User;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDto[] dtos);

    User getRandomUser();

    List<UsersSoldProductsDto> findAllSoldProducts();

    UsersAndProductsDto findAllUsersWithSoldProductsOrderByProductCount();
}
