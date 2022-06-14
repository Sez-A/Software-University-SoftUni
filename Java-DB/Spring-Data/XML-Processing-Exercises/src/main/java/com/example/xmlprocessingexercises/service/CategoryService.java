package com.example.xmlprocessingexercises.service;

import com.example.xmlprocessingexercises.model.dto.CategoriesByProductsCountDescRootDto;
import com.example.xmlprocessingexercises.model.dto.CategorySeedDto;
import com.example.xmlprocessingexercises.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    boolean repoIsEmpty();

    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> getRandomCategories();

    CategoriesByProductsCountDescRootDto findAllCategoriesOrderByProductsCountDesc();

}
