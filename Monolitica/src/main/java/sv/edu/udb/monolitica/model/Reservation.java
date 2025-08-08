package sv.edu.udb.monolitica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreSala;
    private String reservadoPor;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
