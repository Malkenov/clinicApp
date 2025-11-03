package com.clinicApp.clinicApp.mapper;

import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public static Doctor toEntity(DoctorRequestDto dto){
        return Doctor.builder()
                .email(dto.getEmail())
                .firstName(dto.getLastName())
                .lastName(dto.getLastName())
                .specialization(dto.getSpecialization())
                .experienceYears(dto.getExperienceYears())
                .build();
    }
}
