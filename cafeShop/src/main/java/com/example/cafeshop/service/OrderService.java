package com.example.cafeshop.service;

import com.example.cafeshop.model.service.OrderServiceModel;
import com.example.cafeshop.model.view.OrderView;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderView> getAllOrders();

    List<OrderView> getAllOrdersOrderedByPriceDesc();

    Integer totalNeededTime();

    void deleteById(Long id);
}
