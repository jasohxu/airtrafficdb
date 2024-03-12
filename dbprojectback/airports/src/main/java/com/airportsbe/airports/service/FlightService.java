package com.airportsbe.airports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airportsbe.airports.model.Flight;
import com.airportsbe.airports.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository FlightRepo;

    public List<Flight> findAll() {
        return FlightRepo.findAll();
    }

    public Flight findByFlightNumber(Integer flightNumber) {
        return FlightRepo.findByFlightNumber(flightNumber);
    }

    public Flight saveFlight(Flight flight) {
        return FlightRepo.save(flight);
    }

    public void deleteFlight(Integer flightNumber) {
        FlightRepo.deleteById(flightNumber);
    }

    @Transactional
    public Flight updateFlight(Integer flightNumber, Flight flightDetails) {
        Optional<Flight> flightOptional = FlightRepo.findById(flightNumber);

        if (flightOptional.isPresent()) {
            Flight existingFlight = flightOptional.get();

            if(flightDetails.getDestination() != null) {
                existingFlight.setDestination(flightDetails.getOrigin());
            }

            if(flightDetails.getOrigin() != null) {
                existingFlight.setOrigin(flightDetails.getOrigin());
            }

            if(flightDetails.getArrivalTime() != null) {
                existingFlight.setArrivalTime(flightDetails.getArrivalTime());
            }

            if(flightDetails.getDepartureTime() != null) {
                existingFlight.setDepartureTime(flightDetails.getDepartureTime());
            }

            if(flightDetails.getAirline() != null) {
                existingFlight.setAirline(flightDetails.getAirline());
            }

            return FlightRepo.save(existingFlight);
        } else {
            throw new RuntimeException("Flight not found with flight number: " + flightNumber);
        }
    }
}
