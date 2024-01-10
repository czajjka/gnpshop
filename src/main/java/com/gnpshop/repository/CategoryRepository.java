package com.gnpshop.repository;

import com.gnpshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

//@Repository
//@ResponseBody
public interface CategoryRepository /*extends JpaRepository<Category, Integer> */{
	Optional<Category> findCategoryById(final Integer id);

	Category findCategoryByName(final String categoryName);

	List<Category> getAllCategories();

	void addCategory(final Category category);

//	@Query(nativeQuery = true)
	void updateCategory(final Category oldCategory, final Category newCategory);

	void deleteCategory(final Category category);
}
