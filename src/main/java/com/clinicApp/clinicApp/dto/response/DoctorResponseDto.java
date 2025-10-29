package com.clinicApp.clinicApp.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {

    private String firstName;
    private String lastName;
    private String description;
    private int experienceYears;
    private String email;
    private List<AppendableRespunseDto> appendables;
}
