package com.clinicApp.clinicApp.mapper;

import com.clinicApp.clinicApp.dto.request.AppointmentRequestDto;
import com.clinicApp.clinicApp.dto.response.AppointmentResponseDto;
import com.clinicApp.clinicApp.entity.Appointment;
import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.entity.Patient;
import jakarta.persistence.Column;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component

public class AppointmentMapper {


    public static Appointment toEntity(AppointmentRequestDto dto, Doctor doctor, Patient patient) {
        return Appointment.builder()
                    .doctor_id(doctor)
                    .patient_id(patient)
                    .dateTime(dto.getDateTime())
                    .build();
    }


    public static AppointmentResponseDto toDto(Appointment appointment){
       return AppointmentResponseDto.builder()
               .dateTime(appointment.getDateTime())
               .doctor(appointment.getDoctor_id().getFirstName())
               .patient(appointment.getPatient_id().getFirstName())
               .build();
    }
}

