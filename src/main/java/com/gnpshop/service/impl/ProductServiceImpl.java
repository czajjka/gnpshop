package com.gnpshop.service.impl;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Category;
import com.gnpshop.entities.Product;
import com.gnpshop.repository.AuthorRepository;
import com.gnpshop.repository.CategoryRepository;
import com.gnpshop.repository.ProductRepository;
import com.gnpshop.service.ProductService;
import com.gnpshop.service.dto.ProductAddResponse;
import com.gnpshop.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

//@Service
public class ProductServiceImpl/* implements ProductService*/ {
//    @Autowired
    private ProductRepository productRepository;

    //We need it for dropdown while adding product
//    @Autowired
    private CategoryRepository categoryRepository;

    //We need it for dropdown while adding product
//    @Autowired
    private AuthorRepository authorRepository;

//    @Override
    //TODO: Check if not better Product addProduct(Product product) ??
    public ProductAddResponse addProduct(Integer productId, String productName, String productDescription, String productImage,
                                         Integer stockQuantity, BigDecimal productPrice, String productType,
                                         String categoryName, String authorName) {

        try {
            //TODO: Finish validation
            //VALIDATION
            if (productId == null || productId <= 0) {
                throw new IllegalArgumentException("Invalid product ID.");
            }

            if (productName == null || productName.isEmpty()) {
                throw new IllegalArgumentException("Product name is required.");
            }

            // NEW PRODUCT
            Product product = new Product();
            product.setId(productId);
            product.setName(productName);
            product.setDescription(productDescription);
            product.setImage(productImage);
            product.setStockQuantity(stockQuantity);
            product.setPrice(productPrice);
            product.setType(productType);

            //CATEGORY
            Category category = categoryRepository.findCategoryByName(categoryName);
            //TODO: Give a possibility to add a new Category if non of the existing categories are relevant
//        if (category == null) {
//
//        }
//            product.setCategory(category);


            //AUTHOR

            // Set the author by finding it from the repository
            Author author = authorRepository.findAuthorByName(authorName);
            //TODO: Give a possibility to add a new Author if non of the existing are relevant
//            product.setAuthor(author);


//            productRepository.save(product);

            return new ProductAddResponse(true, "Product added successfully", product);
        } catch (Exception e) {
            return new ProductAddResponse(false, "Failed to add product: " + e.getMessage(), null);
        }

    }

//    @Override
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }

//    @Override
//    public Product getProductById(Integer productId) {
//        return productRepository.findById(productId)
//                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));
//    }

//    @Override
//    public Product getProductByName(String productName) {
//        return productRepository.findProductByName(productName)
//                .orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + productName));
//    }
}
