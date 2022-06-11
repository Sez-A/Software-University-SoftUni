package com.example.automappingex.service;

import com.example.automappingex.model.dto.GameTitleDto;
import com.example.automappingex.model.dto.LoginUserDto;
import com.example.automappingex.model.dto.UserRegisterDto;

import java.util.Set;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(LoginUserDto loginUserDto);

    String logout();

    boolean haveLoggedAdmin();

    String buyGame(String gameName);

    Set<GameTitleDto> findAllGamesOfLoggedInUser();
}
