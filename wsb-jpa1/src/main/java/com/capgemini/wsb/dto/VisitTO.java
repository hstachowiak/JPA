package com.capgemini.wsb.dto;

import java.util.List;

public class VisitTO {

    private Long id;
    private String description;
    private String time;
    private DoctorTO doctor; // assuming DoctorTO is defined
    private PatientTO patient; // assuming PatientTO is defined
    private List<MedicalTreatmentTO> medicalTreatments; // assuming MedicalTreatmentTO is defined

    // getters and setters
}
