package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByLastName(String lastname);
}
