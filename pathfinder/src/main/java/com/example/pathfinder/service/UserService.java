package com.example.pathfinder.service;

import com.example.pathfinder.model.service.UserLoginServiceModel;
import com.example.pathfinder.model.service.UserRegisterServiceModel;
import com.example.pathfinder.model.view.UserProfileView;

public interface UserService {
    boolean loginUser(UserLoginServiceModel serviceModel);

    void logout();

    boolean register(UserRegisterServiceModel registerServiceModel);

    UserProfileView findById(Long id);
}
