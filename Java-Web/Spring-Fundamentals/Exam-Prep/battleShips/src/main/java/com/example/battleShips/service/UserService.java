package com.example.battleShips.service;

import com.example.battleShips.model.entity.User;
import com.example.battleShips.model.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    void register(UserServiceModel registerServiceModel);

    boolean loginUser(UserServiceModel loginServiceModel);

    Optional<User> findUserById(Long id);
}
