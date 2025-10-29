package com.clinicApp.clinicApp.dto.response;


import com.clinicApp.clinicApp.entity.Appointment;
import com.clinicApp.clinicApp.entity.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private LocalDate birthData;
    private List<AppointmentResponseDto> appointments;
    private String specializationName;
}
