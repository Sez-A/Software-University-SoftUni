package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.model.service.UserRegisterServiceModel;
import com.example.pathfinder.model.view.UserProfileView;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.RoleService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterServiceModel registerServiceModel) {
        User user = this.modelMapper.map(registerServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(registerServiceModel.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleService.getRoleByName("USER"));
        user.setRoles(roles);
        user.setLevel(LevelEnum.BEGINNER);
        this.userRepository.save(user);
        return true;
    }

    @Override
    public UserProfileView findById(Long id) {
        return this.modelMapper.map(this.userRepository.findById(id).get(), UserProfileView.class);
    }

    @Override
    public User findUserEntityById(Long id) {
        return this.userRepository.findById(id).orElse(this.userRepository.findById(1L).get());
    }

    @Override
    public UserProfileView findCurrentLoggedIn(Principal principal) {
        return modelMapper.map(this.userRepository.findByUsername(principal.getName()).get(), UserProfileView.class);
    }
}
