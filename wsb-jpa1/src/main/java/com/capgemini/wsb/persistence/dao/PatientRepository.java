package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Object findByLastName(String lastName);

    Object findPatientsByVisitCount(int visitCount);

    Object findPatientsByCustomField(String customField);
}