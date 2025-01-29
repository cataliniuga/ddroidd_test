package com.example.ddroidd_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ddroidd_test.model.Aplication;
import com.example.ddroidd_test.service.AplicationService;

@RestController
@RequestMapping("/applications")
public class AplicationController {

    @Autowired
    private AplicationService aplicationService;

    @GetMapping
    public List<Aplication> getAllAplications() {
        return aplicationService.findAll();
    }

    @PostMapping("/{applicantId}/{joblistingId}")
    public Aplication createApplication(@PathVariable Long applicantId, @PathVariable Long joblistingId) {
        return aplicationService.save(applicantId, joblistingId);
    }

    @GetMapping("/{jobListingId}")
    public ResponseEntity<?> findApplicantsByJobListingId(@PathVariable Long jobListingId) {
        return new ResponseEntity<>(aplicationService.findAllAplicantsByJobListing(jobListingId), HttpStatus.OK);

    }

}