package com.example.ddroidd_test.repository;
import com.example.ddroidd_test.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Repository Aplicanti
 */

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    public Applicant findApplicantById(Long applicantId);
}
