package com.example.cafeshop.service.impl;

import com.example.cafeshop.model.entity.Orders;
import com.example.cafeshop.model.service.OrderServiceModel;
import com.example.cafeshop.model.view.OrderView;
import com.example.cafeshop.repository.OrderRepository;
import com.example.cafeshop.service.CategoryService;
import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.service.UserService;
import com.example.cafeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Orders order = this.modelMapper.map(orderServiceModel, Orders.class);
        order.setEmployee(this.userService.findById(this.currentUser.getId()));
        order.setCategory(this.categoryService.findByName(orderServiceModel.getCategory()));

        this.orderRepository.save(order);
    }

    @Override
    public List<OrderView> getAllOrders() {

        return this.orderRepository
                .findAll()
                .stream()
                .map(order -> {
                    OrderView view = this.modelMapper.map(order, OrderView.class);
                    view.setCategory(order.getCategory().getName());
                    return view;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderView> getAllOrdersOrderedByPriceDesc() {
        return this.orderRepository
                .findOrdersOrderByPriceDesc()
                .stream()
                .map(order -> {
                    OrderView view = this.modelMapper.map(order, OrderView.class);
                    view.setCategory(order.getCategory().getName());
                    return view;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Integer totalNeededTime() {
        return this.orderRepository.totalNeededTime();
    }

    @Override
    public void deleteById(Long id) {
        this.orderRepository.deleteById(id);
    }
}
