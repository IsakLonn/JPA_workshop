package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "AppUser")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

        @Column(unique = true)
        private String username;

        private String password;

        private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        regDate = LocalDate.now();
    }
}
