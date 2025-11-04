package com.clinicApp.clinicApp.mapper;

import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.dto.response.DoctorResponseDto;
import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.entity.Specialization;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public static Doctor toEntity(DoctorRequestDto dto, Specialization specializations){
        return Doctor.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstname())
                .lastName(dto.getLastName())
                .specializations(specializations)
                .experienceYears(dto.getExperienceYears())
                .build();
    }

    public static DoctorResponseDto toDto(Doctor doctor){
        return DoctorResponseDto.builder()
                .email(doctor.getEmail())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .specializations(doctor.getSpecializations().getName())
                .experienceYears(doctor.getExperienceYears())
                .build();
    }
}
