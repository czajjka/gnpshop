package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<Order, Integer> {
    Iterable<Order> findOrderById(Integer id);
}
