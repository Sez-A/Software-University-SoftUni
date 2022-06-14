package com.example.xmlprocessingexercises.repository;

import com.example.xmlprocessingexercises.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE " +
            "(SELECT count (p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL) > 1" +
            " ORDER BY u.lastName, u.firstName ")
    List<User> usersWithAtLeastOneSoldProduct();


    @Query("SELECT u FROM User u WHERE " +
            "(SELECT count (p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL)  > 1 " +
            " ORDER BY u.soldProducts.size DESC, u.lastName ")
    List<User> usersWithAtLeastOneSoldProductOrderByProductsCntDesc();
}
