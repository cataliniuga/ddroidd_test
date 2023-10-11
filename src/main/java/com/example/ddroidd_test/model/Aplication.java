package com.example.ddroidd_test.model;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    Employer employer;

    @OneToOne
    @JoinColumn(name = "joblisting_id", referencedColumnName = "id")
    JobListing jobListing;

    public Aplication(Employer employer, JobListing jobListing) {
        this.employer = employer;
        this.jobListing = jobListing;
    }
}
