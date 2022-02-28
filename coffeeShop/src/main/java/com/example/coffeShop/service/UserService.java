package com.example.coffeShop.service;

import com.example.coffeShop.model.entity.User;
import com.example.coffeShop.model.service.UserServiceModel;
import com.example.coffeShop.model.view.EmployeeView;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    boolean loginUser(UserServiceModel userServiceModel);

    void logoutUser();

    User findById(Long id);

    List<EmployeeView> findAll();
}
