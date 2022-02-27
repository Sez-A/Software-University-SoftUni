package com.example.coffeShop.service;

import com.example.coffeShop.model.entity.Category;
import com.example.coffeShop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void populateCategories();

    Category findByName(CategoryNameEnum name);
}
