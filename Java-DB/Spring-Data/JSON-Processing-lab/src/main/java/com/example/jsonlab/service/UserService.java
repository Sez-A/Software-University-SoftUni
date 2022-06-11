package com.example.jsonlab.service;

import com.example.jsonlab.model.dto.UserCreateDto;
import com.example.jsonlab.model.dto.UserCreatedResponseDto;

import java.util.List;

public interface UserService {
    String save(UserCreateDto dto);

    UserCreatedResponseDto saveWithResponse(UserCreateDto dto);

    List<UserCreatedResponseDto> findAllUsers();

    UserCreatedResponseDto findUserById(Long id);
}
