package com.clinicApp.clinicApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {

    @NotBlank(message = "Введите к какому врачу хотите записаться!")
    private String doctor;

    @NotBlank(message = "Введите данные пациенита!")
    private String patient;

    @NotNull
    private LocalDateTime dataTime;

}
