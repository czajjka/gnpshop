package com.gnpshop.service;

import com.gnpshop.entities.Category;
import com.gnpshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Category addCategory(String categoryName, Integer categoryId) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCategoryId(categoryId);

        return categoryRepository.save(category);
    }

    public Iterable<Category> searchCategoryById(Integer categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    //TODO: write method changeCategoryPosition (most likely we need parentId parameter)
    public void changeCategoryPosition(Integer categoryId, Integer newPosition) {

    }
}
