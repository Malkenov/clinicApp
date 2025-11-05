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

    @NotNull(message = "Введите к какому врачу хотите записаться!")
    private Long doctorId;

    @NotNull(message = "Введите данные пациента!")
    private Long patientId;

    @NotNull
    private LocalDateTime dateTime;

}
