package com.clinicApp.clinicApp.service;

import com.clinicApp.clinicApp.dto.request.AppointmentRequestDto;
import com.clinicApp.clinicApp.dto.response.AppointmentResponseDto;
import com.clinicApp.clinicApp.entity.Appointment;
import com.clinicApp.clinicApp.exception.NotFoundException;
import com.clinicApp.clinicApp.mapper.AppointmentMapper;
import com.clinicApp.clinicApp.mapper.DoctorMapper;
import com.clinicApp.clinicApp.repository.AppointmentRepository;
import com.clinicApp.clinicApp.utils.BeanUtilsHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.availability.ApplicationAvailabilityBean;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final ApplicationAvailabilityBean applicationAvailability;

    public List<AppointmentResponseDto> getAll(){
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDto)
                .toList();
    }

    public AppointmentResponseDto getById(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Запись не найдена!"));

        return AppointmentMapper.toDto(appointment);
    }

    public AppointmentResponseDto update(AppointmentRequestDto dto,Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Запись не найдена!"));
        BeanUtils.copyProperties(dto, appointment, BeanUtilsHelper.getNullPropertyNames(dto));
        appointmentRepository.save(appointment);
        return AppointmentMapper.toDto(appointment);
    }
}
