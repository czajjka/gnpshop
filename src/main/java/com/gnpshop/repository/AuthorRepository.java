package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository
public interface AuthorRepository /*extends JpaRepository<Author, Integer>*/ {
    Iterable<Author> findAuthorById(Integer id);

    Author findAuthorByName(String authorName);
}
