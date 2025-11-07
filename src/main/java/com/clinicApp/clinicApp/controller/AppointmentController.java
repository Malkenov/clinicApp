package com.clinicApp.clinicApp.controller;

import com.clinicApp.clinicApp.dto.request.AppointmentRequestDto;
import com.clinicApp.clinicApp.dto.response.AppointmentResponseDto;
import com.clinicApp.clinicApp.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> postAppointment(){
        List<AppointmentResponseDto> dto = appointmentService.getAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> updateAppointment(
            @RequestBody @Validated AppointmentRequestDto dto,
            @PathVariable Long id){
        return ResponseEntity.ok(appointmentService.update(dto,id));
    }

}
