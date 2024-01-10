package com.gnpshop.service;

import com.gnpshop.entities.Category;
import com.gnpshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
//@RequiredArgsConstructor
//@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    /*public Category addCategory(String categoryName, Integer categoryId) {
        Category category = new Category();
        category.setName(categoryName);
        category.setId(categoryId);

        return categoryRepository.save(category);
    }*/

//    public Optional<Category> searchCategoryById(Integer categoryId) {
//        return categoryRepository.findCategoryById(categoryId);
//    }

    //TODO: write method changeCategoryPosition (most likely we need parentId parameter)
    public void changeCategoryPosition(Integer categoryId, Integer newPosition) {

    }

    public Optional<Category> getCategoryById(final Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    public Optional<Category> addCategory(final Category category) {
        final Optional<Category> qualifedCategory = findCategoryById(category.getId());
        if (qualifedCategory.isPresent()) {
            log.error("Category with id {} already exist", category.getId());
            return Optional.empty();
        }
        categoryRepository.addCategory(category);
        return Optional.of(category);
    }

    private Optional<Category> findCategoryById(final Integer id) {
        final List<Category> categoryList = categoryRepository.getAllCategories();
        return categoryList.stream()
                .filter(category -> category.getId().equals(id))
                .findFirst();
    }

    public Category addOrUpdatedCategory(final Integer id, final Category category) {
        final Optional<Category> qualifiedCategory = findCategoryById(id);
        if (qualifiedCategory.isEmpty()) {
            log.error("Category with id {} not found. Creating new database entry", id);
            categoryRepository.addCategory(category);
            return category;
        }
        log.info("Category with id {} was found. Preforming updat", id);
        categoryRepository.updateCategory(qualifiedCategory.get(), category);
        return category;
    }

    public Optional<Category> deleteCategoryById(final Integer id) {
        final Optional<Category> qualifiedCategory = findCategoryById(id);
        if (qualifiedCategory.isEmpty()) {
            return Optional.empty();
        }
        categoryRepository.deleteCategory(qualifiedCategory.get());
        return Optional.of(qualifiedCategory.get());
    }
}
