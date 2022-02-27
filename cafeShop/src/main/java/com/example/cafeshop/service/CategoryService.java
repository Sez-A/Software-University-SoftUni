package com.example.cafeshop.service;

import com.example.cafeshop.model.entity.Category;
import com.example.cafeshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void populateCategories();

    Category findByName(CategoryNameEnum name);
}
