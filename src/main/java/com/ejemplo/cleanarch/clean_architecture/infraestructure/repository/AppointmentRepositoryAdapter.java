package com.ejemplo.cleanarch.clean_architecture.infraestructure.repository;

import com.ejemplo.cleanarch.clean_architecture.application.port.AppointmentRepository;
import com.ejemplo.cleanarch.clean_architecture.domain.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AppointmentRepositoryAdapter implements AppointmentRepository {

    private final JpaAppointmentRepository jpaAppointmentRepository;

    public AppointmentRepositoryAdapter(JpaAppointmentRepository jpaAppointmentRepository) {
        this.jpaAppointmentRepository = jpaAppointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return jpaAppointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return jpaAppointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return jpaAppointmentRepository.findAll();
    }
}