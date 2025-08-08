package sv.edu.udb.monolitica.repository;

import sv.edu.udb.monolitica.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
