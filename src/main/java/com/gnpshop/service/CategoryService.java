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
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Optional<Category> getCategoryById(final Integer id) {
		return categoryRepository.findById(id);
	}

	public Optional<Category> addCategory(final Category category) {
		final Optional<Category> qualifedCategory = findCategoryById(category.getId());
		if (qualifedCategory.isPresent()) {
			log.error("Category with id {} already exist", category.getId());
			return Optional.empty();
		}
		categoryRepository.save(category);
		return Optional.of(category);
	}

    public Optional<Category> deleteCategoryById(final Integer id) {
        final Optional<Category> qualifiedCategory = findCategoryById(id);
        if (qualifiedCategory.isEmpty()) {
            return Optional.empty();
        }
        categoryRepository.deleteById(id);
        return qualifiedCategory;
    }

	private Optional<Category> findCategoryById(final Integer id) {
		final List<Category> categoryList = categoryRepository.findAll();
		return categoryList.stream()
				.filter(category -> category.getId().equals(id))
				.findFirst();
	}
}
