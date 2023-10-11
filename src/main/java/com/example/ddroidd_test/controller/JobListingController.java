package com.example.ddroidd_test.controller;

import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import com.example.ddroidd_test.service.EmployerService;
import com.example.ddroidd_test.service.JobListingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<JobListing> getAllJobListings() {
        return jobListingService.findAll();
    }

    @PostMapping("/{employerId}")
    public JobListing createJobListing(@PathVariable Long employerId, @RequestBody JobListing jobListing) {
        return jobListingService.save(jobListing, employerId);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<?> findJobListingsByEmployer(@PathVariable Long employerId){
        return new ResponseEntity<>(jobListingService.findAllByEmployer(employerId), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{jobListingId}")
    public ResponseEntity<?> deleteJobListing(@PathVariable Long jobListingId){
        try {
            jobListingService.deleteJobListingById(jobListingId);
            return ResponseEntity.ok("Job Listing deleted.");
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Job Listing Found.");
        }
    }


}
