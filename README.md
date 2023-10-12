# ddroidd_test

Pentru realizarea proiectului s-a folosit Java, Spring Boot, Postgres.
Pentru aplicatie am considerat urmatoarele entitati, cu atributele respective:


##### Employer - pentru angajator
id - long
firstName - string
lastName - string

##### Applicant - pentru aplicanti
id - long
firstName - string
lastName - string

##### JobListing - job-urile postate spre aplicare
id - long
title - string
employerId - long

##### Application - aplicatia depusa de un aplicant catre un joblisting
id - long
applicant - Applicant
jobListing - JobListing
phone - string
email - string
adress - string
country - string
state - string
city - string


#### Endpoints pentru:
- View all employers - /employers [GET]
- View all applicants - /applicants [GET]
- View all job listings - /jobs [GET]
- View all applications - /applications [GET]
- Create an employer - /employers [POST]
- Create an applicant - /applicants [POST]
- Create a job listing - /jobs/{employerId} [POST]
- Create an application - /applications/{applicantId}/{joblistingId} [POST]
- Create a method to add a new Job Listing for one of the Employers - /jobs/{employerId} [POST]
- Create a method to allow people to apply for a job listing - /applications/{applicantId}/{joblistingId} [POST]
- Create a method to display all Job Listings for an Employer - /jobs/{employerId} [GET]
- Create a method that gets all applicants for an Employer - /applicants/{employerId} [GET]
- Create a method that gets all applicants for a Job Listing - /applications/{jobListingId} [GET]
- Create a method to delete a job listing - /jobs/delete/{jobListingId} [DELETE]
