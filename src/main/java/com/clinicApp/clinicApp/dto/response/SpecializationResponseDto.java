package com.clinicApp.clinicApp.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecializationResponseDto {

    private String name;
    private String description;
    private String doctor;
}
