package com.ejemplo.cleanarch.clean_architecture.interfaceadapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {

    private String patientName;
    private String patientEmail;
    private String doctorName;
    private String doctorSpecialty;
    private String symptomsOrDiagnosis;
    private LocalDateTime appointmentTime;
    private String room;

}