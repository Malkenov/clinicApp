package com.clinicApp.clinicApp.controller;


import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.dto.response.DoctorResponseDto;
import com.clinicApp.clinicApp.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;


    @PostMapping
    public ResponseEntity<DoctorResponseDto> postDoctor(@RequestBody @Validated DoctorRequestDto dto){
        return ResponseEntity.ok(doctorService.postDoctor(dto));
    }


    @GetMapping
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctor(){
        List<DoctorResponseDto> dto = doctorService.getAllDoctor();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<DoctorResponseDto> getByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(doctorService.getByLastName(lastName));
    }

    @PatchMapping
    public ResponseEntity<DoctorResponseDto> patchDoctor(@RequestBody DoctorRequestDto dto){
        return ResponseEntity.ok(doctorService.updateDoctor(dto));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String email){
        doctorService.removeDoctor(email);
        return ResponseEntity.noContent().build();
    }

}
