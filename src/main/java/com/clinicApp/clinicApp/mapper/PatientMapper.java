package com.clinicApp.clinicApp.mapper;

import com.clinicApp.clinicApp.dto.request.PatientRequestDto;
import com.clinicApp.clinicApp.dto.response.PatientResponseDto;
import com.clinicApp.clinicApp.entity.Appointment;
import com.clinicApp.clinicApp.entity.Patient;
import com.clinicApp.clinicApp.entity.Specialization;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientMapper {


    public static Patient toEntity(PatientRequestDto dto){
        Patient patient = new Patient();
        patient.setEmail(dto.getEmail());
        patient.setFirstName(dto.getFirstname());
        patient.setLastName(dto.getLastName());
        patient.setBirthData(dto.getBirthData());
        patient.setPhoneNumber(dto.getPhoneNumber());
        return patient;
    }

    public static PatientResponseDto toDto(Patient patient){
        return PatientResponseDto.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .birthData(patient.getBirthData())
                .appointments(
                        patient.getAppointmentList().stream()
                                .map(AppointmentMapper::toDto)
                                .toList()
                )
                .build();
    }

    public static PatientResponseDto toResponseDto(
            Patient patient,
            List<Appointment> appointments){
        return PatientResponseDto.builder()
                .email(patient.getEmail())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .birthData(patient.getBirthData())
                .phoneNumber(patient.getPhoneNumber())
                .appointments(appointments.stream()
                        .map(AppointmentMapper ::toDto)
                        .toList())
                .build();

    }
}
