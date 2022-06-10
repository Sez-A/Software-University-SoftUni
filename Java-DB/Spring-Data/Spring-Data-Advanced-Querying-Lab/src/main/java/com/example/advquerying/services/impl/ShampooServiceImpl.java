package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllShampoosBySize(Size size) {
        return this.shampooRepository.findAllBySize(size);
    }

    @Override
    public List<Shampoo> findAllShampoosBySizeOrLabelOrderedByPrice(Size size, long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findAllShampoosByPriceHigherThan(BigDecimal price) {

        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int findAllShampooCountByPriceLowerThan(BigDecimal price) {

        return this.shampooRepository.countAllByPriceLessThan(price);

    }

    @Override
    public List<String> findAllShampoosWithIngredientsIn(List<String> ingredientsIn) {
        return this.shampooRepository.findAllShampoosWithIngredientsIn(ingredientsIn)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllShampoosByIngredientCountLessThan(int count) {
        return this.shampooRepository.findAllShampoosByIngredientCountLessThan(count)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }
}
