package com.example.ddroidd_test.repository;


import com.example.ddroidd_test.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    public Employer findEmployerById(Long employerId);
}
