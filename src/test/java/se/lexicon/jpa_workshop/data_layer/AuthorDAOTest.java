package se.lexicon.jpa_workshop.data_layer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.jpa_workshop.data_layer.impl.AuthorDAO;
import se.lexicon.jpa_workshop.data_layer.impl.BookDAO;
import se.lexicon.jpa_workshop.entity.Author;
import se.lexicon.jpa_workshop.entity.Book;

@SpringBootTest
@Rollback
@Transactional
public class AuthorDAOTest {

    @Autowired
    AuthorDAO DAO;

    @Autowired
    BookDAO bDAO;

    @Test
    public void TestAuthorDAO(){
        Author author = new Author("Test", "Test");


        Book book = new Book("195064", "Book of books", 7);
        Book book2 = new Book("19506432", "Book of books", 7);


        author.addBook(book);
        author.addBook(book2);

        author = DAO.create(author);
        int expected = 1;
        int actual = author.getAuthorId();
        Assertions.assertEquals(expected, actual);
        bDAO.findAll().forEach(System.out::println);
        for (Author a : DAO.findAll()){
            System.out.println(a);
        }
    }
}
