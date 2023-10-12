package com.example.ddroidd_test.service;


import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.EmployerRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class JobListingService{
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;

    public JobListing save(JobListing jobListing, Long employerId){
        Employer employer = employerRepository.findEmployerById(employerId);
        jobListing.setEmployerId(employer.getId());
        //System.out.println(jobListing.getEmployer().getFirstName());
        return jobListingRepository.save(jobListing);
    }

    public List<JobListing> findAll() {
        return jobListingRepository.findAll();
    }

    public List<JobListing> findAllByEmployer(Long employerId){
        //Employer employer = employerRepository.findEmployerById(employerId);
        return jobListingRepository.findJobListingsByEmployerId(employerId);

    }

    public void deleteJobListingById(Long jobListingId)
    {
        JobListing jobListing = jobListingRepository.findJobListingById(jobListingId);
        jobListingRepository.delete(jobListing);
    }
}
