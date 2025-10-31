package com.clinicApp.clinicApp.dto.response;

import com.clinicApp.clinicApp.enums.StatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDto {

    private String doctor;
    private String patient;
    private LocalDateTime dateTime;
    private StatusEnum status;
}
