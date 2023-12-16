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

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    //We need it for dropdown while adding product
    @Autowired
    private CategoryRepository categoryRepository;

    //We need it for dropdown while adding product
    @Autowired
    private AuthorRepository authorRepository;

    @Override
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
            product.setProductId(productId);
            product.setProductname(productName);
            product.setProductpescription(productDescription);
            product.setProductimage(productImage);
            product.setStockquantity(stockQuantity);
            product.setProductprice(productPrice);
            product.setProducttype(productType);

            //CATEGORY

            // TODO: Add method findByCategoryName to Category Repo
            Category category = categoryRepository.findByCategoryName(categoryName);
            //TODO: Give a possibility to add a new Category if non of the existing categories are relevant
//        if (category == null) {
//
//        }
            product.setCategory(category);


            //AUTHOR

            // Set the author by finding it from the repository
            // TODO: Add method findByAuthorName to Author Repo
            Author author = authorRepository.findByAuthorName(authorName);
            //TODO: Give a possibility to add a new Author if non of the existing are relevant
            product.setAuthor(author);


            productRepository.save(product);

            return new ProductAddResponse(true, "Product added successfully", product);
        } catch (Exception e) {
            return new ProductAddResponse(false, "Failed to add product: " + e.getMessage(), null);
        }

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        //TODO: Change Order to Product in Product Repo
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public Product getProductByName(String productName) {
        //TODO: Add method findByProductName in Product Repo
        //return productRepository.findByProductName(productName).orElse(null);
        return productRepository.findByProductName(productName)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + productName));
    }

    //TODO: Do we need that?
    @Override
    public List<Product> searchProducts(String keyword) {
        return null;
    }
}
