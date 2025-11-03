package com.clinicApp.clinicApp.dto.response;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {

    private String firstName;
    private String lastName;
    private String specialization;
    private int experienceYears;
    private String email;
    private List<AppointmentResponseDto> appointment;
}
