package com.example.battleShips.service.impl;

import com.example.battleShips.model.entity.Category;
import com.example.battleShips.model.entity.enums.CategoryName;
import com.example.battleShips.repository.CategoryRepository;
import com.example.battleShips.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


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

        Category cargo = new Category()
                .setName(CategoryName.CARGO);
        Category battle = new Category()
                .setName(CategoryName.BATTLE);
        Category patrol = new Category()
                .setName(CategoryName.PATROL);

        categoryRepository.saveAll(List.of(cargo, battle, patrol));
    }
}
