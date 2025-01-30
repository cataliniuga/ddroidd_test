package com.example.ddroidd_test.service;
import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.AplicationRepository;
import com.example.ddroidd_test.repository.ApplicantRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/*
ApplicantsService
 */
@Service
public class ApplicantsService {
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private AplicationRepository aplicationRepository;
    @Resource
    private ApplicantRepository applicantRepository;

    /*
    Functia salveaza un nou aplicant
     */

    public Applicant save(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    /*
    Functia returneaza toti aplicantii
     */
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    /*
    Functia returneaza toti aplicantii, cautati dupa un anumit angajator
     */
    public List<Applicant> findAllByEmployer(Long employerId){

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
                    applicants.add(aplication.getApplicant());
                }
            }
            }
        return applicants;
        }

    public ResponseEntity<?> delete(Long applicantId) {
        applicantRepository.deleteById(applicantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
