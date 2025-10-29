package com.clinicApp.clinicApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Врачи")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "имя")
    private String firstName;

    @Column(name = "фамилия")
    private String lastName;

    @Column(name = "специальность")
    private String specialization;

    @Column(name = "стаж")
    private int experienceYears;

    @Column
    private String email;

    @OneToMany(mappedBy = "doctor_id")
    @JsonIgnore
    private List<Appointment> appointmentList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(email, doctor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

