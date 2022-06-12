package com.example.jsonprocessingexercises.service.impl;

import com.example.jsonprocessingexercises.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessingexercises.model.dto.CategorySeedDto;
import com.example.jsonprocessingexercises.model.entity.Category;
import com.example.jsonprocessingexercises.model.entity.Product;
import com.example.jsonprocessingexercises.repository.CategoryRepository;
import com.example.jsonprocessingexercises.service.CategoryService;
import com.example.jsonprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    public void seedCategories(CategorySeedDto[] dtos) {
        if (this.categoryRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
                .filter(validationUtil::isValid)
                .map(seedDto -> modelMapper.map(seedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int categoriesCount = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < categoriesCount; i++) {
            long id = ThreadLocalRandom.current().nextLong(1, this.categoryRepository.count() + 1);
            categories.add(this.categoryRepository.findById(id).orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoriesByProductsCountDto> findCategoriesWithProductsCount() {
        List<Category> categories = this.categoryRepository.findAll();

        List<CategoriesByProductsCountDto> dtos = new ArrayList<>();

        for (Category category : categories) {
            CategoriesByProductsCountDto dto = new CategoriesByProductsCountDto();
            dto.setName(category.getName());
            dto.setProductCount(category.getProducts().size());

            double avgSum = 0.0;
            for (Product product : category.getProducts()) {
                avgSum += Double.parseDouble(product.getPrice().toString());
            }
            avgSum /= category.getProducts().size();
            dto.setAveragePrice(String.format("%.6f", avgSum));
            double totalPrice = 0.0;
            for (Product product : category.getProducts()) {
                totalPrice += Double.parseDouble(product.getPrice().toString());
            }
            dto.setTotalPrice(String.format("%.2f", totalPrice));
            dtos.add(dto);
        }

        return dtos
                .stream()
                .sorted((d1, d2) -> d2.getProductCount().compareTo(d1.getProductCount()))
                .collect(Collectors.toList());

    }
}
