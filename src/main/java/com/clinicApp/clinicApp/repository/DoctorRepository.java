package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
