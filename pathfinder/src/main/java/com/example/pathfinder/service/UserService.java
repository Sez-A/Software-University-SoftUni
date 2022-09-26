package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.service.UserRegisterServiceModel;
import com.example.pathfinder.model.view.UserProfileView;

import java.security.Principal;

public interface UserService {
    boolean register(UserRegisterServiceModel registerServiceModel);

    UserProfileView findById(Long id);

    User findUserEntityById(Long id);

    UserProfileView findCurrentLoggedIn(Principal principal);

}
