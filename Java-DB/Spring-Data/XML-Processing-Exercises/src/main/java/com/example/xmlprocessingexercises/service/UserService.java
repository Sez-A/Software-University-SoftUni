package com.example.xmlprocessingexercises.service;

import com.example.xmlprocessingexercises.model.dto.UserSeedDto;
import com.example.xmlprocessingexercises.model.dto.UsersWithSoldProductsRootDto;
import com.example.xmlprocessingexercises.model.entity.User;

import java.util.List;

public interface UserService {
     boolean repoIsEmpty();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UsersWithSoldProductsRootDto usersWithAtLeastOneSoldProduct();

    com.example.xmlprocessingexercises.model.dto.ex_four.UsersWithSoldProductsRootDto
    usersWithAtLeastOneSoldProductOrderByProductsSize();
}
