package com.clinicApp.clinicApp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PatientRequestDto {


    @NotBlank(message = "имя обязательно!")
    private String firstname;

    @NotBlank(message = "фамилия обязательно!")
    private String lastName;

    @Email(message = "email обязательно!")
    private String email;

    @NotNull(message = "номер телефона обязательно!")
    private int phoneNumber;

    @NotNull(message = "дата рождение обязательно!")
    private LocalDate birthData;


}
