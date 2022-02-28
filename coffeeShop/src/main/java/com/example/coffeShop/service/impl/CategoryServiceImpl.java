package com.example.coffeShop.service.impl;

import com.example.coffeShop.model.entity.Category;
import com.example.coffeShop.model.entity.enums.CategoryNameEnum;
import com.example.coffeShop.repository.CategoryRepository;
import com.example.coffeShop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void populateCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .map(categoryName -> {
                    Category category = new Category();
                    category.setName(categoryName);
                    switch (categoryName) {
                        case COFFEE:
                            category.setNeededTime(2);
                            break;
                        case CAKE:
                            category.setNeededTime(10);
                            break;
                        case DRINK:
                            category.setNeededTime(1);
                            break;
                        case OTHER:
                            category.setNeededTime(5);
                            break;
                    }
                    return category;
                })
                .forEach(this.categoryRepository::save);
    }

    @Override
    public Category findByName(CategoryNameEnum name) {
        return this.categoryRepository.findByName(name).orElse(this.categoryRepository.findById(4L).get());
    }
}
