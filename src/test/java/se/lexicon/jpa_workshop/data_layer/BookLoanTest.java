package se.lexicon.jpa_workshop.data_layer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.jpa_workshop.data_layer.impl.BookLoanDAO;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Book;
import se.lexicon.jpa_workshop.entity.BookLoan;

import java.time.LocalDate;

@Transactional
@Rollback
@SpringBootTest
public class BookLoanTest {

    @Autowired
    BookLoanDAO DAO;

    @Test
    public void TestBookLoan(){
        AppUser borrower = new AppUser("Test", "Test");
        Book book = new Book("195064", "Book of books", 7);
        BookLoan loan = new BookLoan(LocalDate.of(2024,4,1), borrower,book);
        DAO.create(loan);

        for (BookLoan bl : DAO.findAll()){
            System.out.println(bl.getLoanId());
        }
        Assertions.assertNotNull(loan);
    }
}
