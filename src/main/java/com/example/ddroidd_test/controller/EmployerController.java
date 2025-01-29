package com.example.ddroidd_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.service.EmployerService;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.findAll();
    }

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerService.save(employer);
    }

}
