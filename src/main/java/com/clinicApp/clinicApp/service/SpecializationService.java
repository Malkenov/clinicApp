package com.clinicApp.clinicApp.service;

import com.clinicApp.clinicApp.dto.request.SpecializationRequestDto;
import com.clinicApp.clinicApp.dto.response.SpecializationResponseDto;
import com.clinicApp.clinicApp.entity.Specialization;
import com.clinicApp.clinicApp.exception.NotFoundException;
import com.clinicApp.clinicApp.mapper.SpecializationMapper;
import com.clinicApp.clinicApp.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    @Transactional
    public SpecializationResponseDto postSpecialization(SpecializationRequestDto dto){
        Specialization specialization = SpecializationMapper.toEntity(dto);
        specializationRepository.save(specialization);
        return SpecializationMapper.toDto(specialization);
    }

    public List<SpecializationResponseDto> getAll(){
        return specializationRepository.findAll().stream()
                .map(SpecializationMapper::toDto)
                .toList();
    }

    public SpecializationResponseDto getByName(String name){
        Specialization specialization = specializationRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Ничего не найдено!"));
        return SpecializationMapper.toDto(specialization);
    }

    @Transactional
    public void removeSpecialization(String name){
        if(!specializationRepository.existsByName(name)){
            throw new NotFoundException("Ничего не найдено!");
        }
        specializationRepository.deleteByName(name);
    }
}
