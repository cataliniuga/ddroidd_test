package com.example.ddroidd_test.repository;



import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.model.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    public JobListing findJobListingById(Long jobListingId);

    public List<JobListing> findJobListingsByEmployerId(Long employerId);

}
