package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.FlightDTO;
import co.edu.unbosque.viajes_global.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin("*")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController() {

    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();

        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addFlight(@RequestBody FlightDTO flight) {
        flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body("The flight is on the web!");
    }
}