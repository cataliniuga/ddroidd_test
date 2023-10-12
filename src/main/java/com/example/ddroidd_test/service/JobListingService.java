package com.example.ddroidd_test.service;
import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.EmployerRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/*
JobListingService
 */

@Service
public class JobListingService{
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;

    /*
    Functia salveaza un nou JobListing
     */
    public JobListing save(JobListing jobListing, Long employerId){
        Employer employer = employerRepository.findEmployerById(employerId);
        jobListing.setEmployerId(employer.getId());
        return jobListingRepository.save(jobListing);
    }

    /*
    Functia returneaza toate joblisting-urile
     */
    public List<JobListing> findAll() {
        return jobListingRepository.findAll();
    }

    /*
    Functia returneaza toate joblisting-urile cautate dupa un employer
     */
    public List<JobListing> findAllByEmployer(Long employerId){
        return jobListingRepository.findJobListingsByEmployerId(employerId);

    }

    /*
    Functia sterge un joblisting existent
     */
    public void deleteJobListingById(Long jobListingId)
    {
        JobListing jobListing = jobListingRepository.findJobListingById(jobListingId);
        jobListingRepository.delete(jobListing);
    }
}
