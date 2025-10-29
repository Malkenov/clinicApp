package com.clinicApp.clinicApp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Пациенты")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "имя")
    private String firstName;

    @Column(name = "фамилия")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(name = "телефон")
    private int phoneNumber;

    @Column(name = "дата рождения")
    private LocalDate birthData;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(email, patient.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
