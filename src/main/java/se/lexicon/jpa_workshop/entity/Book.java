package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "authors")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String isbn;
    private String title;
    private int maxLoanDays;
    @Builder.Default
    private boolean available = true;

    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors = new HashSet<>();



    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void removeAuthor(Author author){authors.remove(author);}
    void addLoan(AppUser borrower){
        if (available){
            available=false;
            BookLoan bookLoan = BookLoan.builder()
                    .book(this)
                    .borrower(borrower)
                    .build();
        }
        else {
            throw new IllegalArgumentException("Book is already borrowed");
        }
    }
    void removeLoan(){
        available=true;
    }
}


