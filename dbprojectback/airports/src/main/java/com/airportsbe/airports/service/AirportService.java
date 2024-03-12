package com.airportsbe.airports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airportsbe.airports.model.Airport;
import com.airportsbe.airports.repository.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepo;

    public List<Airport> findAll() {
        return airportRepo.findAll();
    }

    public Airport findByAbbreviation(String abbreviation) {
        return airportRepo.findByAbbreviation(abbreviation);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepo.save(airport);
    }

    public void deleteAirport(String abbreviation) {
        airportRepo.deleteById(abbreviation);
    }

    @Transactional
    public Airport updateAirport(String abbreviation, Airport airportDetails) {
        Optional<Airport> airportOptional = airportRepo.findById(abbreviation);

        if (airportOptional.isPresent()) {
            Airport existingAirport = airportOptional.get();

            if(airportDetails.getFullName() != null) {
                existingAirport.setFullName(airportDetails.getFullName());
            }

            if(airportDetails.getCity() != null) {
                existingAirport.setCity(airportDetails.getCity());
            }

            return airportRepo.save(existingAirport);
        } else {
            throw new RuntimeException("Airport not found with abbreviation: " + abbreviation);
        }
    }
}
