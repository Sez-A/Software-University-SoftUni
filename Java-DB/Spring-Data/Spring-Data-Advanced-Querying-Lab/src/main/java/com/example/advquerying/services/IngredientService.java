package com.example.advquerying.services;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    List<String> findAllIngredientsByNameStartsWith(String startsWith);

    List<String> findAllIngredientsByNames(List<String> names);

    int deleteIngredientByName(String name);

    int updateAllIngredientsPriceByTenPercent();

    int updateAllIngredientsByNameIn(List<String> names, BigDecimal percent);
}
