package com.example.cafeshop.service.impl;

import com.example.cafeshop.model.entity.User;
import com.example.cafeshop.model.service.UserServiceModel;
import com.example.cafeshop.model.view.EmployeeView;
import com.example.cafeshop.repository.UserRepository;
import com.example.cafeshop.service.UserService;
import com.example.cafeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword());

        if (user.isPresent()) {
            currentUser.setId(user.get().getId());
            return true;
        }

        return false;
    }

    @Override
    public void logoutUser() {
        this.currentUser.setId(null);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeView> findAll() {

        return this.userRepository.findAllOrderedByOrdersDesc()
                .stream()
                .map(user -> {
                    EmployeeView employeeView = this.modelMapper.map(user, EmployeeView.class);
                    employeeView.setNumberOfOrders(user.getOrders().size());
                    return employeeView;
                })
                .collect(Collectors.toList());
    }
}
