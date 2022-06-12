package com.example.jsonprocessingexercises.service.impl;

import com.example.jsonprocessingexercises.model.dto.ProductInRangeDto;
import com.example.jsonprocessingexercises.model.dto.ProductSeedDto;
import com.example.jsonprocessingexercises.model.entity.Product;
import com.example.jsonprocessingexercises.repository.ProductRepository;
import com.example.jsonprocessingexercises.service.CategoryService;
import com.example.jsonprocessingexercises.service.ProductService;
import com.example.jsonprocessingexercises.service.UserService;
import com.example.jsonprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts(ProductSeedDto[] dtos) {
        if (this.productRepository.count() > 0) {
            return;
        }

        this.processDtos(dtos);

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Arrays.stream(dtos)
                .filter(validationUtil::isValid)
                .map(dto -> modelMapper.map(dto, Product.class))
                .forEach(productRepository::save);
    }

    @Override
    public List<ProductInRangeDto> findAllProductsInRange(double lower, double upper) {
        return this.productRepository
                .findByPriceBetweenAndBuyerIdIsNullOrderByPrice(new BigDecimal(lower), new BigDecimal(upper))
                .stream()
                .map(product -> {
                    ProductInRangeDto productInRangeDto = modelMapper.map(product, ProductInRangeDto.class);
                    productInRangeDto.setSeller(String.format("%s %s"
                            , product.getSeller().getFirstName()
                            , product.getSeller().getLastName()));
                    return productInRangeDto;
                })
                .collect(Collectors.toList());
    }

    private void processDtos(ProductSeedDto[] dtos) {
        int buyerIdSetDecisionMaker = 0;
        for (ProductSeedDto dto : dtos) {
            if (buyerIdSetDecisionMaker % 2 == 0) {
                dto.setBuyerId(this.userService.getRandomUser());
            }
            dto.setSellerId(this.userService.getRandomUser());
            dto.setCategories(this.categoryService.getRandomCategories());
            buyerIdSetDecisionMaker++;
            if (buyerIdSetDecisionMaker == 10) {
                buyerIdSetDecisionMaker = 1;
            }
        }
    }
}
