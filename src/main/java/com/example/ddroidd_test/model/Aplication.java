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
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    Applicant applicant;

    @OneToOne
    @JoinColumn(name = "joblisting_id", referencedColumnName = "id")
    JobListing jobListing;

    public Aplication(Applicant applicant, JobListing jobListing) {
        this.applicant = applicant;
        this.jobListing = jobListing;
    }
}
