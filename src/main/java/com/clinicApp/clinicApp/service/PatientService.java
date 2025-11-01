package com.clinicApp.clinicApp.service;

import com.clinicApp.clinicApp.dto.request.PatientRequestDto;
import com.clinicApp.clinicApp.dto.response.AppointmentResponseDto;
import com.clinicApp.clinicApp.dto.response.PatientResponseDto;
import com.clinicApp.clinicApp.entity.Appointment;
import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.entity.Patient;
import com.clinicApp.clinicApp.entity.Specialization;
import com.clinicApp.clinicApp.exception.BadRequestException;
import com.clinicApp.clinicApp.exception.NotFoundException;
import com.clinicApp.clinicApp.mapper.PatientMapper;
import com.clinicApp.clinicApp.repository.AppointmentRepository;
import com.clinicApp.clinicApp.repository.DoctorRepository;
import com.clinicApp.clinicApp.repository.PatientRepository;
import com.clinicApp.clinicApp.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final SpecializationRepository specializationRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;


    public PatientResponseDto postPatientAppointment(PatientRequestDto dto,Long id){
        Patient patient = PatientMapper.toEntity(dto);

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Нету такого врача!"));

        Appointment appointment = new Appointment();
        appointment.setDoctor_id(doctor);
        appointment.setPatient_id(patient);
        appointment.setDateTime(LocalDateTime.now());
        appointmentRepository.save(appointment);

      return PatientMapper.toResponseDto(patient, List.of(appointment));
    }


    public PatientResponseDto postPatient(PatientRequestDto dto){
        Patient patient = PatientMapper.toEntity(dto);
        patientRepository.save(patient);
        return PatientMapper.toDto(patient);
    }

    public List<PatientResponseDto> getByAll(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDto)
                .toList();
    }

    public PatientResponseDto getByLastName(PatientRequestDto dto){
        Patient patient = patientRepository.findByLastName(dto.getLastName())
                .orElseThrow(() -> new BadRequestException("Пациент с фамилией " + dto.getLastName() + " не найден!"));
        return PatientMapper.toDto(patient);
    }
}
