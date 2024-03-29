package com.gnpshop.service;

import com.gnpshop.entities.Product;
import com.gnpshop.service.dto.ProductAddResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductServiceNikola {

//    Product addProduct(Product product);

     ProductAddResponse addProduct(Integer productId, String productName, String productDescription, String productImage,
                                   Integer stockQuantity, BigDecimal productPrice, String productType,
                                   String categoryName, String authorName) throws IllegalArgumentException;

    List<Product> getAllProducts();

    Product getProductById(Integer productId);
    Product getProductByName(String productName);

}
