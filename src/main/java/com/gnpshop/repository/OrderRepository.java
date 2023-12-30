package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OrderRepository/*extends JpaRepository<Order, Integer>*/ {
    Iterable<OrderRepository> findOrderRepositoryById(Integer id);
}
