package com.example.ddroidd_test.service;

import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.AplicationRepository;
import com.example.ddroidd_test.repository.EmployerRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicationService {
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;
    @Resource
    private AplicationRepository aplicationRepository;

    public Aplication save(Long employerId, Long jobListingId){
        Employer employer = employerRepository.findEmployerById(employerId);
        JobListing jobListing = jobListingRepository.findJobListingById(jobListingId);
        return aplicationRepository.save(new Aplication(employer, jobListing));
    }

    public List<Aplication> findAll() {
        return aplicationRepository.findAll();
    }

}
