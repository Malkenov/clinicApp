package com.clinicApp.clinicApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecializationRequestDto {

    @NotBlank(message = "Название специалиста обязательно!")
    private String name;

    @NotBlank(message = "Краткое описание специалиста")
    private String description;

    @NotBlank
    private String doctor;
}
