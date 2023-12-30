package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Repository
@ResponseBody
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoryById(Integer id);

    Category findCategoryByName(String categoryName);

}
