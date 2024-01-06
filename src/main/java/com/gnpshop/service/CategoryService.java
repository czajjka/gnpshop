package com.gnpshop.service;

import com.gnpshop.entities.Category;
import com.gnpshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Category addCategory(String categoryName, Integer categoryId) {
        Category category = new Category();
        category.setName(categoryName);
        category.setId(categoryId);

        return categoryRepository.save(category);
    }

//    public Optional<Category> searchCategoryById(Integer categoryId) {
//        return categoryRepository.findCategoryById(categoryId);
//    }

    //TODO: write method changeCategoryPosition (most likely we need parentId parameter)
    public void changeCategoryPosition(Integer categoryId, Integer newPosition) {

    }

    public Optional<Category> getCategoryById(final Integer id) {
        return categoryRepository.findCategoryById(id);
    }

}
