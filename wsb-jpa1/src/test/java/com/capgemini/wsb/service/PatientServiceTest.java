package com.capgemini.wsb.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class PatientServiceTest {

    private PatientRepository patientRepository;
    private PatientServiceImpl patientService;

    @Before
    public void setUp() {
        patientRepository = mock(PatientRepository.class);
        patientService = new PatientServiceImpl(patientRepository, null);
    }

    // Test dla zapytania "Znajdź pacjentów po nazwisku"
    // Nowy test
    @Test
    public void testFindPatientByLastName_DAO() {
        // Given
        String lastName = "Kowalczyk";
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setLastName(lastName);
        List<PatientEntity> patients = List.of(patientEntity);

        // When
        when(patientRepository.findByLastName(lastName)).thenReturn(patients);
        List<PatientTO> foundPatients = patientService.findPatientsByLastName(lastName);

        // Then
        assertEquals(1, foundPatients.size());
        assertEquals(lastName, foundPatients.get(0).getLastName());
    }

    // Test dla zapytania "Znajdź wszystkie wizyty pacjenta po jego ID"
    // Test dodany wcześniej, dla zapytania serwisu
    @Test
    public void testFindVisitsByPatientId_Service() {
        // Given
        Long patientId = 1L;
        List<VisitTO> visits = List.of(new VisitTO()); // Mocking visit objects

        // When
        when(patientService.findVisitsByPatientId(patientId)).thenReturn(visits);
        List<VisitTO> foundVisits = patientService.findVisitsByPatientId(patientId);

        // Then
        assertEquals(visits.size(), foundVisits.size());
    }

    // Test dla zapytania "Znajdź pacjentów którzy mieli więcej niż X wizyt"
    // Test dodany wcześniej, dla zapytania DAO
    @Test
    public void testFindPatientsByVisitCount_DAO() {
        // Given
        int visitCount = 2;
        List<PatientEntity> patients = List.of(new PatientEntity(), new PatientEntity()); // Mocking patient objects

        // When
        when(patientRepository.findPatientsByVisitCount(visitCount)).thenReturn(patients);
        List<PatientEntity> foundPatients = patientService.findPatientsByVisitCount(visitCount);

        // Then
        assertEquals(patients.size(), foundPatients.size());
    }

    // Test dla zapytania "Znajdź pacjentów po dodanym przez Ciebie polu"
    // Test dodany wcześniej, dla zapytania DAO
    @Test
    public void testFindPatientsByCustomField_DAO() {
        // Given
        String customField = "customValue";
        List<PatientEntity> patients = List.of(new PatientEntity()); // Mocking patient objects

        // When
        when(patientRepository.findPatientsByCustomField(customField)).thenReturn(patients);
        List<PatientEntity> foundPatients = patientService.findPatientsByCustomField(customField);

        // Then
        assertEquals(patients.size(), foundPatients.size());
    }
}
