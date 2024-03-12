package com.airportsbe.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airportsbe.airports.model.Passenger;
import com.airportsbe.airports.service.PassengerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.findAll();
    }

    @GetMapping("/{passengerID}")
    public ResponseEntity<Passenger> getPassengerByPassengerID(@PathVariable Integer passengerID) {
        Passenger passenger = passengerService.findByPassengerID(passengerID);
        return passenger != null ? ResponseEntity.ok(passenger) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @PutMapping("/{passengerID}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Integer passengerID, @RequestBody Passenger PassengerDetails) {
        Passenger updatedPassenger = passengerService.updatePassenger(passengerID, PassengerDetails);
        return updatedPassenger != null ? ResponseEntity.ok(updatedPassenger) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{passengerID}")
    public ResponseEntity<?> deletePassenger(@PathVariable Integer passengerID) {
        passengerService.deletePassenger(passengerID);
        return ResponseEntity.ok().build();
    }

    // Other endpoint methods
}
