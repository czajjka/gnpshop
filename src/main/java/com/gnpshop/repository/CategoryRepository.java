package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Iterable<Category> findCategoryById(Integer id);
}
