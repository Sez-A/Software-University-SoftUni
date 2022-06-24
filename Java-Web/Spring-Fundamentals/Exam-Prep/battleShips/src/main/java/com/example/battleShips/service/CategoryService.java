package com.example.battleShips.service;

import com.example.battleShips.model.entity.Category;

import java.util.Optional;

public interface CategoryService {
    void populateCategories();

    Optional<Category> findCategoryByCategoryName(String categoryName);
}
