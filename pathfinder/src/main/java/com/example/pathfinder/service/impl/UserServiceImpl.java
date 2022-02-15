package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.model.service.UserLoginServiceModel;
import com.example.pathfinder.model.service.UserRegisterServiceModel;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.RoleService;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public boolean loginUser(UserLoginServiceModel serviceModel) {

        Optional<User> user = this.userRepository.findByUsername(serviceModel.getUsername());
        if (user.isEmpty() || !serviceModel.getPassword().equals(user.get().getPassword())) {
            return false;
        }


        User loggedIn = user.get();
        this.currentUser.setUsername(loggedIn.getUsername());
        this.currentUser.setId(loggedIn.getId());

        loggedIn.getRoles()
                .forEach(r -> currentUser.addRole(r.getRole()));

        return true;
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }

    @Override
    public boolean register(UserRegisterServiceModel registerServiceModel) {
        User user = this.modelMapper.map(registerServiceModel, User.class);
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleService.getRoleByName("USER"));
        user.setRoles(roles);
        user.setLevel(LevelEnum.BEGINNER);
        this.userRepository.save(user);
        return true;
    }
}
