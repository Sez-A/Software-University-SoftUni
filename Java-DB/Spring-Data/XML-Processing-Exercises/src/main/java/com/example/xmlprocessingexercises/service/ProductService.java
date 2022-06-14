package com.example.xmlprocessingexercises.service;

import com.example.xmlprocessingexercises.model.dto.ProductInRangeRootDto;
import com.example.xmlprocessingexercises.model.dto.ProductSeedDto;

import java.util.List;

public interface ProductService {
    boolean repoIsEmpty();

    void seedProducts(List<ProductSeedDto> products);

    ProductInRangeRootDto findAllProductsInRange();
}
