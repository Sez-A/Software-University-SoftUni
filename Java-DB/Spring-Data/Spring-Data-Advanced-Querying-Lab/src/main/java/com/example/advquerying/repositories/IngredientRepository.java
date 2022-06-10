package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String startsWith);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    @Transactional
    @Modifying
    int deleteByName(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Ingredient i SET i.price = i.price * 1.1")
    int updateAllIngredientsPriceWithTenPercent();

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price + (i.price * :percent) WHERE i.name IN(:names)")
    int updateAllIngredientsByNameIn(List<String> names, BigDecimal percent);

}
