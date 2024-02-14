package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "AppUser")
@NoArgsConstructor
@AllArgsConstructor
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

        @Column(unique = true)
        private String email;

        private String name;

        private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    public AppUser(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
