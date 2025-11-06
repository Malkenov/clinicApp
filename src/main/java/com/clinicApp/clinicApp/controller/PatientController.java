package com.clinicApp.clinicApp.controller;

import com.clinicApp.clinicApp.dto.request.PatientRequestDto;
import com.clinicApp.clinicApp.dto.response.PatientResponseDto;
import com.clinicApp.clinicApp.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDto> postPatient(@RequestBody PatientRequestDto dto){
        PatientResponseDto patientResponseDto = patientService.postPatient(dto);
        return ResponseEntity.ok(patientResponseDto);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> postAppointmentPatient(
            @RequestBody PatientRequestDto dto,
            @PathVariable Long id){
        PatientResponseDto patientResponseDto = patientService.postPatientAppointment(dto, id);
        return ResponseEntity.ok(patientResponseDto);
    }


}
