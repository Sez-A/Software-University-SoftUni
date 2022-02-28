package com.example.coffeShop.service;

import com.example.coffeShop.model.service.OrderServiceModel;
import com.example.coffeShop.model.view.OrderView;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderView> getAllOrders();

    List<OrderView> getAllOrdersOrderedByPriceDesc();

    Integer totalNeededTime();

    void deleteById(Long id);
}
