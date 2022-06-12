package com.example.jsonprocessingexercises.service;

import com.example.jsonprocessingexercises.model.dto.ProductInRangeDto;
import com.example.jsonprocessingexercises.model.dto.ProductSeedDto;

import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductInRangeDto> findAllProductsInRange(double lower, double upper);
}
