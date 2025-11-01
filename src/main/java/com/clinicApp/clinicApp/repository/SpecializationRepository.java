package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    Optional<Specialization> findByName(String message);
}
