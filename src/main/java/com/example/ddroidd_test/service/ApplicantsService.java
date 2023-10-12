package com.example.ddroidd_test.service;
import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.AplicationRepository;
import com.example.ddroidd_test.repository.ApplicantRepository;
import com.example.ddroidd_test.repository.EmployerRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantsService {
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;
    @Resource
    private AplicationRepository aplicationRepository;
    @Resource
    private ApplicantRepository applicantRepository;

    public Applicant save(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    public List<Applicant> findAllByEmployer(Long employerId){
        //Employer employer = employerRepository.findEmployerById(employerId);
        List <JobListing> jobs = jobListingRepository.findJobListingsByEmployerId(employerId);
        List <Aplication> aplications = aplicationRepository.findAll();
        List <Applicant> applicants = new ArrayList<>();

        for (JobListing job : jobs)
        {
            System.out.println(job.getId());
            for (Aplication aplication : aplications)
            {
                System.out.println(aplication.getId());
                if (aplication.getJobListing()==job) {
                    System.out.println("da");
                    applicants.add(aplication.getApplicant());
                }
            }
            }
        return applicants;
        }





}
