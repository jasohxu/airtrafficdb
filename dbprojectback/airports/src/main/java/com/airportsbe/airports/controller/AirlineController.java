package com.airportsbe.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.airportsbe.airports.model.Airline;
import com.airportsbe.airports.service.AirlineService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineService.findAll();
    }

    @GetMapping("/{abbreviation}")
    public ResponseEntity<Airline> getAirlineByAbbreviation(@PathVariable String abbreviation) {
        Airline airline = airlineService.findByAbbreviation(abbreviation);
        return airline != null ? ResponseEntity.ok(airline) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.saveAirline(airline);
    }

    @PutMapping("/{abbreviation}")
    public ResponseEntity<Airline> updateAirline(@PathVariable String abbreviation, @RequestBody Airline airlineDetails) {
        Airline updatedAirline = airlineService.updateAirline(abbreviation, airlineDetails);
        return updatedAirline != null ? ResponseEntity.ok(updatedAirline) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{abbreviation}")
    public ResponseEntity<?> deleteAirline(@PathVariable String abbreviation) {
        airlineService.deleteAirline(abbreviation);
        return ResponseEntity.ok().build();
    }

    // Other endpoint methods
}
