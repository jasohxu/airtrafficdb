package com.airportsbe.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airportsbe.airports.model.Airport;
import com.airportsbe.airports.service.AirportService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.findAll();
    }

    @GetMapping("/{abbreviation}")
    public ResponseEntity<Airport> getAirportByAbbreviation(@PathVariable String abbreviation) {
        Airport airport = airportService.findByAbbreviation(abbreviation);
        return airport != null ? ResponseEntity.ok(airport) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.saveAirport(airport);
    }

    @PutMapping("/{abbreviation}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String abbreviation, @RequestBody Airport airportDetails) {
        Airport updatedAirport = airportService.updateAirport(abbreviation, airportDetails);
        return updatedAirport != null ? ResponseEntity.ok(updatedAirport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{abbreviation}")
    public ResponseEntity<?> deleteAirport(@PathVariable String abbreviation) {
        airportService.deleteAirport(abbreviation);
        return ResponseEntity.ok().build();
    }

    // Other endpoint methods
}
