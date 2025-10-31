package com.clinicApp.clinicApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationResponseDto {

    private String name;
    private String description;
    private String doctor;
}
