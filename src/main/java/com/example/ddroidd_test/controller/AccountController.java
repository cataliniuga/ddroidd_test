package com.example.ddroidd_test.controller;

import com.example.ddroidd_test.model.Account;
import com.example.ddroidd_test.model.Applicant;
import com.example.ddroidd_test.service.AccountService;
import com.example.ddroidd_test.service.ApplicantsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    private ApplicantsService applicantsService;

    @PostMapping("/register")
    public Account registerAccount(@RequestBody RegisterRequest registerRequest) {
        System.out.println(registerRequest);
        return accountService.register(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getFirstName(), registerRequest.getLastName());
    }

    @PostMapping("/login")
    public Account loginAccount(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    static class LoginRequest {
        private String email;
        private String password;

        public LoginRequest() {
        }

        public LoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    static class RegisterRequest {
        private String email;
        private String password;
        private String firstName;
        private String lastName;

        public RegisterRequest() {
        }

        public RegisterRequest(String email, String password, String firstName, String lastName) {
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setlastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
