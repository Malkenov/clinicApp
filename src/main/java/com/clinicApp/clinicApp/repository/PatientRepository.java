package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
