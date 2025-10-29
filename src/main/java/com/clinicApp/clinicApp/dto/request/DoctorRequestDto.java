package com.clinicApp.clinicApp.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequestDto {

    @NotBlank(message = "имя обязательно!")
    private String firstname;

    @NotBlank(message = "фамилия обязательно!")
    private String lastName;

    @NotBlank(message = "специальность обязательно!")
    private String specialization;

    @NotNull(message = "стаж обязательно!")
    private int experienceYears;

    @Email(message = "email обязательно!")
    private String email;

}
