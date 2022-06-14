package com.example.xmlprocessingexercises.service.impl;

import com.example.xmlprocessingexercises.model.dto.ProductInRangeRootDto;
import com.example.xmlprocessingexercises.model.dto.ProductSeedDto;
import com.example.xmlprocessingexercises.model.dto.ProductWithSellerDto;
import com.example.xmlprocessingexercises.model.entity.Product;
import com.example.xmlprocessingexercises.repository.ProductRepository;
import com.example.xmlprocessingexercises.service.CategoryService;
import com.example.xmlprocessingexercises.service.ProductService;
import com.example.xmlprocessingexercises.service.UserService;
import com.example.xmlprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper
            , ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public boolean repoIsEmpty() {
        return this.productRepository.count() == 0;
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.getRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(876.78)) < 0) {
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setCategories(categoryService.getRandomCategories());
                    return product;
                })
                .forEach(productRepository::save);

    }

    @Override
    public ProductInRangeRootDto findAllProductsInRange() {
        ProductInRangeRootDto inRangeRootDto = new ProductInRangeRootDto();
        inRangeRootDto.setProducts(
                this.productRepository.findAllByPriceBetweenAndBuyerIsNull
                                (BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(product -> {
                    ProductWithSellerDto dto = modelMapper.map(product, ProductWithSellerDto.class);
                    dto.setSeller(product.getSeller().getFirstName()
                            + " "
                            + product.getSeller().getLastName());
                    return dto;
                })
                .collect(Collectors.toList())
        );
        return inRangeRootDto;
    }
}
