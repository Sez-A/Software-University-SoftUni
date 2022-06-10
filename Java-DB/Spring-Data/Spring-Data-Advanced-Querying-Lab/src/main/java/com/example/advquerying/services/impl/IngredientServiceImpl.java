package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.services.IngredientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findAllIngredientsByNameStartsWith(String startsWith) {
        return this.ingredientRepository.findAllByNameStartingWith(startsWith)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllIngredientsByNames(List<String> names) {
        return this.ingredientRepository.findAllByNameInOrderByPrice(names)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public int deleteIngredientByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }

    @Override
    public int updateAllIngredientsPriceByTenPercent() {
        return this.ingredientRepository.updateAllIngredientsPriceWithTenPercent();
    }

    @Override
    public int updateAllIngredientsByNameIn(List<String> names, BigDecimal percent) {
        return this.ingredientRepository.updateAllIngredientsByNameIn(names, percent);
    }
}
