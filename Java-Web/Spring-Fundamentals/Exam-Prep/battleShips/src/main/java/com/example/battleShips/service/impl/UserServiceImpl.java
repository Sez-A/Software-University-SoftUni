package com.example.battleShips.service.impl;

import com.example.battleShips.model.entity.User;
import com.example.battleShips.model.service.UserServiceModel;
import com.example.battleShips.repository.UserRepository;
import com.example.battleShips.service.UserService;
import com.example.battleShips.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserServiceModel registerServiceModel) {
        User userEntity = modelMapper.map(registerServiceModel, User.class);
        userRepository.save(userEntity);
    }

    @Override
    public boolean loginUser(UserServiceModel loginServiceModel) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginServiceModel.getUsername(), loginServiceModel.getPassword());

        if (user.isPresent()) {
            currentUser.setId(user.get().getId());
            return true;
        }

        return false;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
