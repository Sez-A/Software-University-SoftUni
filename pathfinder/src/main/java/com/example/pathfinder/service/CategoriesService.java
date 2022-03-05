package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;

public interface CategoriesService {
    Categories findByName(CategoryNamesEnum name);
}
