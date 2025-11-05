package com.clinicApp.clinicApp.mapper;

import com.clinicApp.clinicApp.dto.request.SpecializationRequestDto;
import com.clinicApp.clinicApp.dto.response.SpecializationResponseDto;
import com.clinicApp.clinicApp.entity.Specialization;
import org.springframework.stereotype.Component;

@Component
public class SpecializationMapper {

    public static Specialization toEntity(SpecializationRequestDto dto){
        return Specialization.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public static SpecializationResponseDto toDto(Specialization specialization){
        return SpecializationResponseDto.builder()
                .name(specialization.getName())
                .description(specialization.getDescription())
                .build();
    }
}
