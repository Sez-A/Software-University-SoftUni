package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findAllShampoosBySize(Size size);

    List<Shampoo> findAllShampoosBySizeOrLabelOrderedByPrice(Size size, long labelId);

    List<Shampoo> findAllShampoosByPriceHigherThan(BigDecimal price);

    int findAllShampooCountByPriceLowerThan(BigDecimal price);

    List<String> findAllShampoosWithIngredientsIn(List<String> ingredientsIn);

    List<String> findAllShampoosByIngredientCountLessThan(int count);
}
