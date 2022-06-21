package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import com.example.pathfinder.repository.CategoriesRepository;
import com.example.pathfinder.service.CategoriesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoriesServiceImplTest {
    private CategoriesService serviceToTest;

    @Mock
    private CategoriesRepository mockCategoriesRepository;

    @BeforeEach
    void init() {
        serviceToTest = new CategoriesServiceImpl(mockCategoriesRepository);
    }

    @Test
    void testFindCategoryByName() {
        Categories expected = new Categories();
        expected.setName(CategoryNamesEnum.CAR);
        Mockito.when(mockCategoriesRepository.findByName(CategoryNamesEnum.CAR))
                .thenReturn(Optional.of(expected));

        Categories actual =
                serviceToTest.findByName(CategoryNamesEnum.CAR);

        assertEquals(expected.getName(), actual.getName());
    }
}