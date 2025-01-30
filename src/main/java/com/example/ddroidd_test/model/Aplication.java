package com.example.ddroidd_test.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications") // You can rename it to "applications" or whatever you prefer
public class Aplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many Aplication entries can point to one Applicant
    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id", nullable = false)
    private Applicant applicant;

    // Many Aplication entries can point to one JobListing
    @ManyToOne(optional = false)
    @JoinColumn(name = "joblisting_id", referencedColumnName = "id", nullable = false)
    private JobListing jobListing;

    // Constructor shortcut if needed
    public Aplication(Applicant applicant, JobListing jobListing) {
        this.applicant = applicant;
        this.jobListing = jobListing;
    }
}
