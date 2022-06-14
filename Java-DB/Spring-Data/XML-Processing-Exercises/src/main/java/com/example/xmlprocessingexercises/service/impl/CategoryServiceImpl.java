package com.example.xmlprocessingexercises.service.impl;

import com.example.xmlprocessingexercises.model.dto.CategoriesByProductsCountDescRootDto;
import com.example.xmlprocessingexercises.model.dto.CategorySeedDto;
import com.example.xmlprocessingexercises.model.dto.CategoryWithProductsInfoDto;
import com.example.xmlprocessingexercises.model.entity.Category;
import com.example.xmlprocessingexercises.model.entity.Product;
import com.example.xmlprocessingexercises.repository.CategoryRepository;
import com.example.xmlprocessingexercises.service.CategoryService;
import com.example.xmlprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean repoIsEmpty() {
        return this.categoryRepository.count() == 0;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {
        int iterCnt = ThreadLocalRandom.current().nextInt(1, 4);
        Set<Category> categories = new HashSet<>();
        long categoryRepoSize = categoryRepository.count() + 1;
        for (int i = 0; i < iterCnt; i++) {
            long categoryId = ThreadLocalRandom.current().nextLong(1, categoryRepoSize);
            categories.add(this.categoryRepository.findById(categoryId).orElse(null));
        }
        return categories;
    }

    @Override
    public CategoriesByProductsCountDescRootDto findAllCategoriesOrderByProductsCountDesc() {
        CategoriesByProductsCountDescRootDto rootDto = new CategoriesByProductsCountDescRootDto();
        rootDto.setCategory(this.categoryRepository.findAllAndOrderProductsCount()
                .stream()
                .map(category -> {
                    CategoryWithProductsInfoDto dto = modelMapper.map(category, CategoryWithProductsInfoDto.class);
                    dto.setProductsCount(category.getProducts().size());

                    double avgPrice = category.getProducts()
                            .stream()
                            .mapToDouble(p -> Double.parseDouble(p.getPrice().toString()))
                            .average()
                            .orElse(0);
                    dto.setAveragePrice(String.format("%.6f", avgPrice));

                    double totalPrice = category.getProducts()
                            .stream()
                            .mapToDouble(p -> Double.parseDouble(p.getPrice().toString()))
                            .sum();
                    dto.setTotalRevenue(String.format("%.2f", totalPrice));

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
