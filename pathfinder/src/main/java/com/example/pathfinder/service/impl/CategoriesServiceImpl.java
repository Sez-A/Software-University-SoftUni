package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import com.example.pathfinder.repository.CategoriesRepository;
import com.example.pathfinder.service.CategoriesService;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Categories findByName(CategoryNamesEnum name) {
        return this.categoriesRepository.findByName(name).orElse(null);
    }
}
