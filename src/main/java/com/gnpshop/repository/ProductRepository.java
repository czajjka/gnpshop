package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Order;
import com.gnpshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface ProductRepository /*extends JpaRepository<Product, Integer>*/ {
    Iterable<ProductRepository> findProductRepositoryById(Integer id);

    Optional<Product> findProductByName(String productName);
}
