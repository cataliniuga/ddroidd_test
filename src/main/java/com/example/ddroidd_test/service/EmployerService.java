package com.example.ddroidd_test.service;
import com.example.ddroidd_test.model.Employer;
import com.example.ddroidd_test.repository.EmployerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/*
EmployerService
 */
@Service
public class EmployerService{
    @Resource
    private EmployerRepository employerRepository;

    /*
    Functie ce salveaza un nou employer
     */
    public Employer save(Employer employer){
        return employerRepository.save(employer);
    }

    /*
    Functie ce returneaza toti employerii
     */
    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

}
