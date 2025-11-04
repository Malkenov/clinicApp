package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findBySpecialization(Specialization specialization);

    Optional<Doctor> findByLastName(String lastName);

    boolean existsByEmail(String email);
}
