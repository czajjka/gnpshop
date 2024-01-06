package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Order;
import com.gnpshop.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoleRepository /*extends JpaRepository<Role, Integer> */{
    Iterable<RoleRepository> findRoleById(Integer id);
}
