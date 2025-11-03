package com.clinicApp.clinicApp.service;

import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.dto.response.DoctorResponseDto;
import com.clinicApp.clinicApp.entity.Doctor;
import com.clinicApp.clinicApp.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;


    public DoctorResponseDto postDoctor(DoctorRequestDto dto){
        Doctor doctor = DoctorMapper
    }
}
