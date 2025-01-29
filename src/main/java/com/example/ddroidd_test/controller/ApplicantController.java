package com.example.ddroidd_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.service.ApplicantsService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantsService applicantsService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantsService.findAll();
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantsService.save(applicant);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<?> findApplicantsByEmployer(@PathVariable Long employerId) {
        return new ResponseEntity<>(applicantsService.findAllByEmployer(employerId), HttpStatus.OK);
    }

}