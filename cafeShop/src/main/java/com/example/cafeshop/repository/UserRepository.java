package com.example.cafeshop.repository;

import com.example.cafeshop.model.entity.User;
import com.example.cafeshop.model.view.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u ORDER BY size(u.orders) DESC")
    List<User> findAllOrderedByOrdersDesc();
}
