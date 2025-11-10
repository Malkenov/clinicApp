package com.clinicApp.clinicApp.controller;

import com.clinicApp.clinicApp.dto.request.PatientRequestDto;
import com.clinicApp.clinicApp.dto.response.PatientResponseDto;
import com.clinicApp.clinicApp.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    private final RequestToViewNameTranslator requestToViewNameTranslator;

    @PostMapping
    public ResponseEntity<PatientResponseDto> postPatient(@RequestBody @Validated PatientRequestDto dto){
        return ResponseEntity.ok(patientService.postPatient(dto));
    }

    @PostMapping("/appointments")
    public ResponseEntity<PatientResponseDto> postAppointmentPatient(
            @RequestBody @Validated PatientRequestDto dto,
            @PathVariable Long id){
        return ResponseEntity.ok(patientService.postPatientAppointment(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatient(){
        return ResponseEntity.ok(patientService.getByAll());
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<PatientResponseDto> getByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(patientService.getByLastName(lastName));
    }

    @PatchMapping
    public ResponseEntity<PatientResponseDto> patchPatient(@RequestBody @Validated PatientRequestDto dto){
        return ResponseEntity.ok(patientService.updatePatient(dto));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> removePatient(@PathVariable String email){
        patientService.removePatient(email);
        return ResponseEntity.noContent().build();
    }
}
