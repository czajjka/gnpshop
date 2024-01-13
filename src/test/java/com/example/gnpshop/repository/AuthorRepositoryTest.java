package com.example.gnpshop.repository;
import com.gnpshop.GNPShopApplication;
import com.gnpshop.entities.Author;
import com.gnpshop.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = GNPShopApplication.class)
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void should_return_author_by_id() {
        // given
        Author author = new Author(1, "John", "Doe", null);
        testEntityManager.persist(author);

        // when
        Iterable<Author> result = authorRepository.findAuthorById(1);

        // then
        List<Author> resultList = Arrays.asList(result.iterator().next());
        assertEquals(1, resultList.size());
        assertEquals(1, resultList.get(0).getId());
        assertEquals("John", resultList.get(0).getFirstname());
        assertEquals("Doe", resultList.get(0).getSurname());
    }
    @Test
    void should_return_author_by_name() {
        // given
        Author author = new Author(1, "John", "Doe", null);
        testEntityManager.persist(author);

        // when
        Author result = authorRepository.findAuthorByName("John");

        // then
        assertEquals(1, result.getId());
        assertEquals("John", result.getFirstname());
        assertEquals("Doe", result.getSurname());
    }
}
