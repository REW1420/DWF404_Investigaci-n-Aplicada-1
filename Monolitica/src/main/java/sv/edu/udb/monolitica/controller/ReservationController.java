package sv.edu.udb.monolitica.controller;

import sv.edu.udb.monolitica.model.Reservation;
import sv.edu.udb.monolitica.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservaciones")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> listar() {
        return service.obtenerTodas();
    }

    @PostMapping
    public Reservation crear(@RequestBody Reservation reservation) {
        return service.guardar(reservation);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
