package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BasketRepository /*extends JpaRepository<Basket, Integer>*/ {
    Iterable<Basket> findBasketById(Integer id);
}
