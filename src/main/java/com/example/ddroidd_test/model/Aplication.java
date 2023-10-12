package com.example.ddroidd_test.model;
import jakarta.persistence.*;
import lombok.*;

/*
Aplicatie

- face legatura dintre aplicant si job
- id - long
- aplicant - Applicant - persoana ce aplica la un job
- joblisting - JobListing - job-ul la care se aplica

- firstname si lastname se preiau de la aplicant
- phone - string
- email - string
- adress - string
- country - string
- state - string
- city - string
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aplication")
public class Aplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    Applicant applicant;

    @OneToOne
    @JoinColumn(name = "joblisting_id", referencedColumnName = "id")
    JobListing jobListing;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    public Aplication(Applicant applicant, JobListing jobListing) {
        this.applicant = applicant;
        this.jobListing = jobListing;
    }
}
