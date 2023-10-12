package com.example.ddroidd_test.controller;
import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
