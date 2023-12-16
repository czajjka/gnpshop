package com.gnpshop.service;

import com.gnpshop.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    //Product addProduct(Product product);

     Product addProduct(Integer productId, String productName, String productDescription, String productImage,
                              Integer stockQuantity, BigDecimal productPrice, String productType,
                              String categoryName, String authorName) throws IllegalArgumentException;

    List<Product> getAllProducts();

    Product getProductById(Integer productId);
    Product getProductByName(String productName);

    //TODO: do we need that?
    List<Product> searchProducts(String keyword);
}
