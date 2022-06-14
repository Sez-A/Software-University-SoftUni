package com.example.xmlprocessingexercises.repository;

import com.example.xmlprocessingexercises.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM  Category c ORDER BY c.products.size DESC")
    Set<Category> findAllAndOrderProductsCount();

}
