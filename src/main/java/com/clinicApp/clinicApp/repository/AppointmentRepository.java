package com.clinicApp.clinicApp.repository;

import com.clinicApp.clinicApp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
