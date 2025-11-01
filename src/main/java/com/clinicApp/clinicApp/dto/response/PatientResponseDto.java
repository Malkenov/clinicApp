package com.clinicApp.clinicApp.dto.response;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private LocalDate birthData;
    private List<AppointmentResponseDto> appointments;
    private String specializationName;
}
