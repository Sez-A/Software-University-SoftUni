package com.example.cafeshop.service;

import com.example.cafeshop.model.entity.User;
import com.example.cafeshop.model.service.UserServiceModel;
import com.example.cafeshop.model.view.EmployeeView;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    boolean loginUser(UserServiceModel userServiceModel);

    void logoutUser();

    User findById(Long id);

    List<EmployeeView> findAll();
}
