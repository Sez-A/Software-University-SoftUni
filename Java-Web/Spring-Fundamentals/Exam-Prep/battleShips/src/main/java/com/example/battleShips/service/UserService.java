package com.example.battleShips.service;

import com.example.battleShips.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel registerServiceModel);

    boolean loginUser(UserServiceModel loginServiceModel);
}
