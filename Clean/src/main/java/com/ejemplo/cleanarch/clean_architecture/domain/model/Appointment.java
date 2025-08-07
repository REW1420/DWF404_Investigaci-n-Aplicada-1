package com.ejemplo.cleanarch.clean_architecture.domain.model;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private String patientName;
    private String patientEmail;
    private String doctorName;
    private String doctorSpecialty;
    private String symptomsOrDiagnosis;
    private LocalDateTime appointmentTime;
    private String room;
}
