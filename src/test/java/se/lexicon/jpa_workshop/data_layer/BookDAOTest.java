package se.lexicon.jpa_workshop.data_layer;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.jpa_workshop.data_layer.impl.BookDAO;
import se.lexicon.jpa_workshop.entity.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Transactional
@Rollback
@SpringBootTest
public class BookDAOTest {

    @Autowired
    BookDAO DAO;

    @Test
    public void TestBook(){
        Book book = new Book("195064", "Book of books", 7);
        DAO.create(book);

        book = new Book("195064", "Book of books", 7);
        DAO.create(book);

        book = new Book("195064", "Book of books", 7);
        DAO.create(book);
        var c = DAO.findAll();
        int expected = 4;
        int actual = c.size();
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
