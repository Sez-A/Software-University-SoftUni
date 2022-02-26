package com.example.cafeshop.service.impl;

import com.example.cafeshop.model.entity.User;
import com.example.cafeshop.model.service.UserServiceModel;
import com.example.cafeshop.repository.UserRepository;
import com.example.cafeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
    }
}
