package com.clinicApp.clinicApp.dto.response;

import com.clinicApp.clinicApp.enums.StatusEnum;

import java.time.LocalDateTime;

public class AppointmentResponseDto {

    private String doctor;
    private String patient;
    private LocalDateTime dateTime;
    private StatusEnum status;
}
