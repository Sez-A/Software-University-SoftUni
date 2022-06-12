package com.example.jsonprocessingexercises.service;


import com.example.jsonprocessingexercises.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessingexercises.model.dto.CategorySeedDto;
import com.example.jsonprocessingexercises.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] dtos);

    Set<Category> getRandomCategories();

    List<CategoriesByProductsCountDto> findCategoriesWithProductsCount();
}
