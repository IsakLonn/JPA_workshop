package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "BookLoan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "borrower")
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    @ManyToOne()
    private AppUser borrower;

    @ManyToOne()
    private Book book;

    public BookLoan(LocalDate dueDate) {
        loanDate = LocalDate.now();
        this.dueDate = calculateDueDate(book.getMaxLoanDays());
        returned = false;
    }
    private LocalDate calculateDueDate(int maxLoanDays){
        return loanDate.plusDays(maxLoanDays);
    }

}
