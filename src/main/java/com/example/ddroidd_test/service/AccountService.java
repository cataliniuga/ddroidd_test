package com.example.ddroidd_test.service;

import com.example.ddroidd_test.model.Account;
import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.repository.AccountRepository;
import com.example.ddroidd_test.repository.ApplicantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    public Account register(String email, String password, String firstName, String lastName) {
        if (accountRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email already taken.");
        }

        Account newAccount = Account.builder()
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        Applicant newApplicant = Applicant.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        applicantRepository.save(newApplicant);
        return accountRepository.save(newAccount);
    }

    public Account login(String email, String password) {
        Account existingAccount = accountRepository.findByEmail(email);
        if (existingAccount == null) {
            throw new RuntimeException("Account not found.");
        }

        if (!existingAccount.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password.");
        }

        return existingAccount;
    }
}
