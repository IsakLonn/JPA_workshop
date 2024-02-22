package se.lexicon.jpa_workshop.data_layer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.jpa_workshop.data_layer.impl.AppUserDAO;
import se.lexicon.jpa_workshop.data_layer.impl.BookDAO;
import se.lexicon.jpa_workshop.data_layer.impl.BookLoanDAO;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Book;
import se.lexicon.jpa_workshop.entity.BookLoan;

import java.time.LocalDate;

@SpringBootTest
@Rollback
@Transactional
public class AppUserDAOTest {

    @Autowired
    AppUserDAO userDAO;

    @Autowired
    BookDAO bookDAO;

    @Autowired
    BookLoanDAO loanDAO;

    @Test
    public void TestAppUser(){
        AppUser user = new AppUser("Test", "Test");

        Book book = new Book("195064", "Book of books", 7);
        bookDAO.create(book);

        BookLoan loan = new BookLoan(LocalDate.of(2024,4,1));
        loan.setBorrower(user);
        loan.setBook(book);
        loanDAO.create(loan);

        user.addLoan(loan);
        user = userDAO.create(user);

        int actual = userDAO.findById(1).getLoans().size();
        int expected = 1;

        System.out.println("Loans");
        loanDAO.findAll().forEach(System.out::println);

        System.out.println("Users");
        userDAO.findAll().forEach(System.out::println);

        System.out.println("Books");
        bookDAO.findAll().forEach(System.out::println);
        Assertions.assertEquals(actual, expected);

    }
}
