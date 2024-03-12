package com.airportsbe.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airportsbe.airports.model.Flight;
import com.airportsbe.airports.service.FlightService;

import java.time.format.DateTimeParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.findAll();
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> getFlightByFlightNumber(@PathVariable Integer flightNumber) {
        Flight flight = flightService.findByFlightNumber(flightNumber);
        return flight != null ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
    // Assuming flight object has time as String which needs to be parsed
    try {
        flight.setDepartureTime(flight.getDepartureTime()); // Custom setter
        flight.setArrivalTime(flight.getArrivalTime()); // Custom setter
    } catch (DateTimeParseException e) {
        // Handle parse exception
    }
    Flight savedFlight = flightService.saveFlight(flight);
    return ResponseEntity.ok(savedFlight);
}

    @PutMapping("/{flightNumber}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer flightNumber, @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(flightNumber, flightDetails);
        return updatedFlight != null ? ResponseEntity.ok(updatedFlight) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<?> deleteFlight(@PathVariable Integer flightNumber) {
        flightService.deleteFlight(flightNumber);
        return ResponseEntity.ok().build();
    }

    // Other endpoint methods
}
