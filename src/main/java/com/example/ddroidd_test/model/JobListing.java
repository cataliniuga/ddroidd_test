package com.example.ddroidd_test.model;
import jakarta.persistence.*;
import lombok.*;
/*
JobListing - job-ul la care se poate aplica

id - long
title - string
employerId - long, id-ul angajatorului care posteaza job listing-ul

 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "joblisting")
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="employer_id")
    private Long employerId;
}
