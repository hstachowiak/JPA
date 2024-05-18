package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    PatientTO getPatientById(Long id);
    void deletePatient(Long id);

    PatientTO findPatientById(Long id);

    List<VisitTO> findVisitsByPatientId(Long patientId);

    List<PatientEntity> findPatientsByVisitCount(int visitCount);

    List<PatientEntity> findPatientsByCustomField(String customField);
}
