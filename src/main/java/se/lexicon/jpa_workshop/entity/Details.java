package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Details")
@NoArgsConstructor
@AllArgsConstructor
@Getter()
public class Details{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int detailsId;

    @Column(unique = true)
    private String email;

    private String name;

    private LocalDate birthdate;


    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthdate = birthDate;
    }
}
