package com.example.ddroidd_test.controller;


import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.service.AplicationService;
import com.example.ddroidd_test.service.EmployerService;
import com.example.ddroidd_test.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class AplicationController {

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private AplicationService aplicationService;

    @GetMapping
    public List<Aplication> getAllAplications() {
        return aplicationService.findAll();
    }

    @PostMapping("/{applicantId}/{joblistingId}")
    public Aplication createJobListing(@PathVariable Long applicantId, @PathVariable Long joblistingId) {
        return aplicationService.save(applicantId, joblistingId);
    }



}