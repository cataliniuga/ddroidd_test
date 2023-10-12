package com.example.ddroidd_test.model;
import jakarta.persistence.*;
import lombok.*;

/*
Employer - angajatorul

id - long
firstName - string
lastname - string

 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
