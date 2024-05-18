package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientTO getPatientById(Long id) {
        PatientEntity patientEntity = patientRepository.findById(id).orElse(null);
        return patientMapper.mapToTO(patientEntity);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientTO findPatientById(Long id) {
        return getPatientById(id);
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        return null;
    }

    @Override
    public List<PatientEntity> findPatientsByVisitCount(int visitCount) {
        return null;
    }

    @Override
    public List<PatientEntity> findPatientsByCustomField(String customField) {
        return null;
    }

    public List<PatientTO> findPatientsByLastName(String lastName) {
        return null;
    }
}
