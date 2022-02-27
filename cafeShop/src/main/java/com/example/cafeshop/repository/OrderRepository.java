package com.example.cafeshop.repository;

import com.example.cafeshop.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o ORDER BY o.price DESC")
    List<Orders> findOrdersOrderByPriceDesc();

    @Query("SELECT sum(o.category.neededTime) FROM Orders o")
    Integer totalNeededTime();
}
