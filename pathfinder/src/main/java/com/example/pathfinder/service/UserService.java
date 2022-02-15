package com.example.pathfinder.service;

import com.example.pathfinder.model.service.UserLoginServiceModel;
import com.example.pathfinder.model.service.UserRegisterServiceModel;

public interface UserService {
    boolean loginUser(UserLoginServiceModel serviceModel);

    void logout();

    boolean register(UserRegisterServiceModel registerServiceModel);
}
