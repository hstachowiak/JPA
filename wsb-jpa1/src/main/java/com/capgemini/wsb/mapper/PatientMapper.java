package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        // Map visits if needed
        // to.setVisits(entity.getVisits().stream().map(visit -> visitMapper.mapToTO(visit)).collect(Collectors.toList()));
        return to;
    }
}
