package com.clinicApp.clinicApp.controller;


import com.clinicApp.clinicApp.dto.request.DoctorRequestDto;
import com.clinicApp.clinicApp.dto.response.DoctorResponseDto;
import com.clinicApp.clinicApp.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;


    public ResponseEntity<DoctorResponseDto> postDoctor(@RequestBody @Validated DoctorRequestDto dto){
        return ResponseEntity.ok(doctorService.postDoctor(dto));
    }


    public ResponseEntity<List<DoctorResponseDto>> getAllDoctor(){
        List<DoctorResponseDto> dto = doctorService.getAllDoctor();
        return ResponseEntity.ok(dto);
    }


}
