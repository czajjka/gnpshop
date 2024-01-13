package com.example.gnpshop.service;
import com.gnpshop.entities.Category;
import com.gnpshop.repository.CategoryRepository;
import com.gnpshop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testGetCategoryById() {
        // Arrange
        int categoryId = 1;
        Category expectedCategory = new Category(categoryId, "TestCategory", null);

        Mockito.when(categoryRepository.findById(categoryId))
                .thenReturn(Optional.of(expectedCategory));

        // Act
        Optional<Category> result = categoryService.getCategoryById(categoryId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedCategory, result.get());
    }

    @Test
    void testAddCategory() {
        // Arrange
        Category newCategory = new Category(2, "NewCategory", null);

        Mockito.when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(categoryRepository.save(newCategory)).thenReturn(newCategory);

        // Act
        Optional<Category> result = categoryService.addCategory(newCategory);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(newCategory, result.get());
    }

    @Test
    void testAddCategoryCategoryExists() {
        // Arrange
        Category existingCategory = new Category(1, "ExistingCategory", null);

        Mockito.when(categoryRepository.findAll()).thenReturn(List.of(existingCategory));

        // Act
        Optional<Category> result = categoryService.addCategory(existingCategory);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void testDeleteCategoryById() {
        // given
        Integer categoryId = 1;
        Category existingCategory = new Category(categoryId, "ExistingCategory", null);

        Mockito.when(categoryRepository.findById(categoryId))
                .thenReturn(Optional.of(existingCategory));

        // when
       Optional<Category> result = categoryService.deleteCategoryById(categoryId);

        // then
        Mockito.verify(categoryRepository).deleteById(categoryId);
        assertTrue(result.isPresent()); // Ensure that the result is present
        assertEquals(existingCategory, result.get());
    }

    @Test
    void testDeleteCategoryByIdCategoryNotExists() {
        // Arrange
        int categoryId = 2;

        Mockito.when(categoryRepository.findById(categoryId))
                .thenReturn(Optional.empty());

        // Act
        Optional<Category> result = categoryService.deleteCategoryById(categoryId);

        // Assert
        assertFalse(result.isPresent());
        Mockito.verify(categoryRepository, Mockito.never()).deleteById(categoryId);
    }
}
