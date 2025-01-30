package com.example.ddroidd_test.service;
import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.repository.AplicationRepository;
import com.example.ddroidd_test.repository.ApplicantRepository;
import com.example.ddroidd_test.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/*
AplicationService
 */
@Service
public class AplicationService {
    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private AplicationRepository aplicationRepository;
    @Resource
    private ApplicantRepository applicantRepository;

    /*
    Functie ce salveaza o noua aplicataie
    Functia preia id-ul aplicantului si id-ul jobului la care acesta doreste sa aplice
    Se cauta aplicantul si job-ul, iar pe baza acestora se creeaza un nou obiect JobListing
     */
    public Aplication save(Long applicantId, Long jobListingId){
        Applicant applicant = applicantRepository.findApplicantById(applicantId);
        JobListing jobListing = jobListingRepository.findJobListingById(jobListingId);
        return aplicationRepository.save(new Aplication(applicant, jobListing));
    }
    /*
    Functie care returneaza toaota aplicatiile
     */
    public List<Aplication> findAll() {
        return aplicationRepository.findAll();
    }

    /*
    Functia care cauta toti aplicantii unui joblisting
    Functia preia toate joblisting-urile si trece cu un for prin ele pentru a selecta candidatii
     */

    public List<Applicant> findAllAplicantsByJobListing(Long jobListingId)
        {
            List<Applicant> applicants = new ArrayList<>();
            List<Aplication> aplications = aplicationRepository.findAll();
            for (Aplication app : aplications)
            {
                if (app.getJobListing().getId().equals(jobListingId))
                {
                    applicants.add(app.getApplicant());
                }
            }

            return applicants;
        }

}
