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
    private int appuserId;

        @Column(unique = true)
        private String email;

        private String name;

        private LocalDate birthDate;
}
