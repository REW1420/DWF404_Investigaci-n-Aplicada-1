package com.ejemplo.cleanarch.clean_architecture.infraestructure.repository;

import com.ejemplo.cleanarch.clean_architecture.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAppointmentRepository extends JpaRepository<Appointment, String> {
}