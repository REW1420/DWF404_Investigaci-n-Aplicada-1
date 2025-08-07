package com.ejemplo.cleanarch.clean_architecture.application.port;


import com.ejemplo.cleanarch.clean_architecture.domain.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository{
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(String id);
    List<Appointment> findAll();
}