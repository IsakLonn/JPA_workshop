package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AppUser")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString()
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

        @Column(unique = true)
        private String username;

        private String password;

        private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Details_id")
    private Details details;

    @OneToMany()
    private List<BookLoan> loans = new ArrayList<>();

    public void addLoan(BookLoan loan){
        loans.add(loan);
    }

    public void removeLoan(BookLoan loan){
        loans.remove(loan);
    }


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        regDate = LocalDate.now();
    }
}
