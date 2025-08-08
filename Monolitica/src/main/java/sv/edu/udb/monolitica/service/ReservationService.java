package sv.edu.udb.monolitica.service;

import sv.edu.udb.monolitica.model.Reservation;
import sv.edu.udb.monolitica.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> obtenerTodas() {
        return repository.findAll();
    }

    public Reservation guardar(Reservation reservation) {
        return repository.save(reservation);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
