package com.example.coffeShop.repository;

import com.example.coffeShop.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o ORDER BY o.price DESC")
    List<Orders> findOrdersOrderByPriceDesc();

    @Query("SELECT sum(o.category.neededTime) FROM Orders o")
    Integer totalNeededTime();
}
