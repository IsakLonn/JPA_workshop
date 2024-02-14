package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Details")
@NoArgsConstructor
@AllArgsConstructor
public class Details{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Column(unique = true)
    private String username;

    private String password;

    private LocalDate regDate;


    public Details(String username, String password) {
        this.username = username;
        this.password = password;
        regDate = LocalDate.now();
    }
}
