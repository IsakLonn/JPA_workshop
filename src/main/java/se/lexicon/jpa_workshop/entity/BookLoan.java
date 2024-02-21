package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "BookLoan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AppUser borrower;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Book book;

    public BookLoan(LocalDate dueDate, AppUser borrower, Book book) {
        loanDate = LocalDate.now();
        this.dueDate = dueDate;
        returned = false;
        this.borrower = borrower;
        this.book = book;
    }
}
