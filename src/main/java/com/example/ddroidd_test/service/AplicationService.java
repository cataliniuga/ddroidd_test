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
public class AplicationService {
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;
    @Resource
    private AplicationRepository aplicationRepository;
    @Resource
    private ApplicantRepository applicantRepository;

    public Aplication save(Long applicantId, Long jobListingId){
        Applicant applicant = applicantRepository.findApplicantById(applicantId);
        JobListing jobListing = jobListingRepository.findJobListingById(jobListingId);
        return aplicationRepository.save(new Aplication(applicant, jobListing));
    }

    public List<Aplication> findAll() {
        return aplicationRepository.findAll();
    }

    public List<JobListing> findAllByEmployer(Long employerId){
        Employer employer = employerRepository.findEmployerById(employerId);
        return jobListingRepository.findJobListingsByEmployer(employer);

    }

    public List<Applicant> findAllAplicantsByJobListing(Long jobListingId)
        {
            List<Applicant> applicants = new ArrayList<>();
            List<Aplication> aplications = aplicationRepository.findAll();
            for (Aplication app : aplications)
            {
                if (app.getJobListing().getId()==jobListingId)
                {
                    applicants.add(app.getApplicant());
                }
            }

            return applicants;
        }

}
