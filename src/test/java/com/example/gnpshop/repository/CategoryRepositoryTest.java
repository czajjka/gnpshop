package com.example.gnpshop.repository;

import com.gnpshop.GNPShopApplication;
import com.gnpshop.entities.Category;
import com.gnpshop.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = GNPShopApplication.class)
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void whenFindByIdThenReturnCategory() {
        // given
        Category category = new Category(1, "TestCategory", null);
        testEntityManager.persist(category);

        // when
        Optional<Category> foundCategory = categoryRepository.findById(1);

        // then
        assertTrue(foundCategory.isPresent());
        assertEquals("TestCategory", foundCategory.get().getName());
    }

    @Test
    void whenFindAllThenReturnAllCategories() {
        // given
        Category category1 = new Category(1, "TestCategory1", null);
        Category category2 = new Category(2, "TestCategory2", null);
        testEntityManager.persist(category1);
        testEntityManager.persist(category2);

        // when
        List<Category> allCategories = categoryRepository.findAll();

        // then
        assertEquals(2, allCategories.size());
    }

}
