package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query(value = "SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN(:ingredientsIn)")
    List<Shampoo> findAllShampoosWithIngredientsIn(List<String> ingredientsIn);

    @Query(value = "SELECT s FROM Shampoo s WHERE s.ingredients.size < :count")
    List<Shampoo> findAllShampoosByIngredientCountLessThan(int count);
}
