package com.ejemplo.cleanarch.clean_architecture.interfaceadapter.controller;

import com.ejemplo.cleanarch.clean_architecture.application.service.AppointmentService;
import com.ejemplo.cleanarch.clean_architecture.domain.model.Appointment;
import com.ejemplo.cleanarch.clean_architecture.interfaceadapter.dto.AppointmentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<List<Appointment>> createAppointments(@RequestBody List<AppointmentRequest> requests) {
        List<Appointment> createdAppointments = requests.stream()
                .map(request -> new Appointment(
                        null,
                        request.getPatientName(),
                        request.getPatientEmail(),
                        request.getDoctorName(),
                        request.getDoctorSpecialty(),
                        request.getSymptomsOrDiagnosis(),
                        request.getAppointmentTime(),
                        request.getRoom()
                ))
                .map(appointmentService::createAppointment)
                .collect(Collectors.toList());

        return ResponseEntity.ok(createdAppointments);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable String id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}
