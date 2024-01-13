package com.example.gnpshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnpshop.GNPShopApplication;
import com.gnpshop.controller.CategoryController;
import com.gnpshop.entities.Category;
import com.gnpshop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryController.class)
@ContextConfiguration(classes = GNPShopApplication.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    void whenGetCategoryByIdThenCategoryShouldBeReturned() throws Exception {
        // given
        Integer id = 1;
        Category category = new Category(id, "Category1", null);
        Mockito.when(categoryService.getCategoryById(id)).thenReturn(Optional.of(category));

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/category/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", equalTo("Category1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product").doesNotExist());
    }

    @Test
    void whenGetCategoryByIdThenCategoryShouldNotBeReturned() throws Exception {
        // given
        Integer id = 1;
        Mockito.when(categoryService.getCategoryById(id)).thenReturn(Optional.empty());

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/category/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void whenAddCategoryThenCategoryShouldBeAdded() throws Exception {
        // given
        Category category = new Category(1, "NewCategory", null);
        Mockito.when(categoryService.addCategory(ArgumentMatchers.any(Category.class))).thenReturn(Optional.of(category));

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.post("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(category)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", equalTo("NewCategory")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product").doesNotExist());
    }

    @Test
    void whenDeleteCategoryByIdThenCategoryShouldBeDeleted() throws Exception {
        // given
        Integer id = 1;
        Category category = new Category(id, "Category1", null);
        Mockito.when(categoryService.deleteCategoryById(id)).thenReturn(Optional.of(category));

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("/category/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted());  // Update this line

    }

    @Test
    void whenDeleteNonExistingCategoryByIdThenNotFound() throws Exception {
        // given
        Integer id = 1;
        Mockito.when(categoryService.deleteCategoryById(id)).thenReturn(Optional.empty());

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("/category/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }


}
