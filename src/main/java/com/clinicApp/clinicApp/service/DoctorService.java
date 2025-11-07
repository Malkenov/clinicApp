package com.clinicApp.clinicApp.service;

import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.dto.response.DoctorResponseDto;
import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.entity.Specialization;
import com.clinicApp.clinicApp.exception.BadRequestException;
import com.clinicApp.clinicApp.exception.NotFoundException;
import com.clinicApp.clinicApp.mapper.DoctorMapper;
import com.clinicApp.clinicApp.repository.DoctorRepository;
import com.clinicApp.clinicApp.repository.SpecializationRepository;
import com.clinicApp.clinicApp.utils.BeanUtilsHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;



    @Transactional
    public DoctorResponseDto postDoctor(DoctorRequestDto dto){
        Specialization specialization = specializationRepository.findByName(dto.getSpecializationName())
                .orElseThrow(() -> new BadRequestException("Введенные данные не существует!"));
        Doctor doctor = DoctorMapper.toEntity(dto,specialization);
        doctorRepository.save(doctor);
        return DoctorMapper.toDto(doctor);
    }

    public List<DoctorResponseDto> getAllDoctor(){
        return doctorRepository.findAll().stream()
                .map(DoctorMapper::toDto)
                .toList();
    }

    public DoctorResponseDto getByLastName(String lastName){
        Doctor doctor = doctorRepository.findByLastName(lastName)
                .orElseThrow(() -> new BadRequestException("Доктор по фамилии " + lastName + " не найден!"));
        return DoctorMapper.toDto(doctor);
    }

    @Transactional
    public DoctorResponseDto updateDoctor(DoctorRequestDto dto){
        Doctor doctor = doctorRepository.findByLastName(dto.getLastName())
                .orElseThrow(() -> new BadRequestException("Доктор по фамилии " + dto.getLastName() + " не найден!"));
        BeanUtils.copyProperties(dto, doctor, BeanUtilsHelper.getNullPropertyNames(dto));
        doctorRepository.save(doctor);
        return DoctorMapper.toDto(doctor);
    }

    @Transactional
    public void removeDoctor(String email){
        if(!doctorRepository.existsByEmail(email)){
            throw new NotFoundException("Доктор по email " + email + " не найден!");
        }
        doctorRepository.deleteByEmail(email);
    }
}
