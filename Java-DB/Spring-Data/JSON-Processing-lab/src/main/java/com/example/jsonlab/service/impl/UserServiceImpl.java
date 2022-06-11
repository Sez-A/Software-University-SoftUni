package com.example.jsonlab.service.impl;

import com.example.jsonlab.model.dto.UserCreateDto;
import com.example.jsonlab.model.dto.UserCreatedResponseDto;
import com.example.jsonlab.model.entity.User;
import com.example.jsonlab.repository.UserRepository;
import com.example.jsonlab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String save(UserCreateDto dto) {
        this.userRepository.save(modelMapper.map(dto, User.class));
        return "Successfully saved " + dto.getFirstName();
    }

    @Override
    public UserCreatedResponseDto saveWithResponse(UserCreateDto dto) {
        User user = this.modelMapper.map(dto, User.class);
        user = this.userRepository.save(user);
        return this.modelMapper.map(user, UserCreatedResponseDto.class);
    }

    @Override
    public List<UserCreatedResponseDto> findAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, UserCreatedResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserCreatedResponseDto findUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + " doesn't exist in DB"));

        return this.modelMapper.map(user, UserCreatedResponseDto.class);
    }
}
