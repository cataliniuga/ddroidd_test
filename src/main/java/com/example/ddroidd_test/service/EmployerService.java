package com.example.ddroidd_test.service;


import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.repository.EmployerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerService{
    @Resource
    private EmployerRepository employerRepository;

    public Employer save(Employer employer){
        return employerRepository.save(employer);
    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

}
