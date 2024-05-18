package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.InsuranceType;

import java.util.List;

public class PatientTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String patientNumber;
    private InsuranceType insuranceType;
    private String dateOfBirth;
    private List<VisitTO> visits; // assuming VisitTO is defined
    private String customField; // assuming the additional field

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // getters and setters
}
