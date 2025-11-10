package com.clinicApp.clinicApp.controller;

import com.clinicApp.clinicApp.dto.request.SpecializationRequestDto;
import com.clinicApp.clinicApp.dto.response.SpecializationResponseDto;
import com.clinicApp.clinicApp.service.SpecializationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/specializations")
public class SpecializationController {

    private final SpecializationService specializationService;


    @PostMapping
    public ResponseEntity<SpecializationResponseDto> postSpecialization(@RequestBody @Validated SpecializationRequestDto dto){
        return ResponseEntity.ok(specializationService.postSpecialization(dto));
    }

    @GetMapping
    public ResponseEntity<List<SpecializationResponseDto>> getAll(){
        List<SpecializationResponseDto> responseDto = specializationService.getAll();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SpecializationResponseDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(specializationService.getByName(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> removeSpecialization(@PathVariable String name){
        specializationService.removeSpecialization(name);
        return ResponseEntity.noContent().build();
    }

}
