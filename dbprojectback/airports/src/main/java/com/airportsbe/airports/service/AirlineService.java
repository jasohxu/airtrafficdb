package com.airportsbe.airports.service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airportsbe.airports.model.Airline;
import com.airportsbe.airports.repository.AirlineRepository;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepo;

    public List<Airline> findAll() {
        return airlineRepo.findAll();
    }

    public Airline findByAbbreviation(String abbreviation) {
        return airlineRepo.findByAbbreviation(abbreviation);
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepo.save(airline);
    }

    public void deleteAirline(String abbreviation) {
        airlineRepo.deleteById(abbreviation);
    }

    @Transactional
    public Airline updateAirline(String abbreviation, Airline airlineDetails) {
        Optional<Airline> airlineOptional = airlineRepo.findById(abbreviation);

        if (airlineOptional.isPresent()) {
            Airline existingAirline = airlineOptional.get();

            if(airlineDetails.getFullName() != null) {
                existingAirline.setFullName(airlineDetails.getFullName());
            }

            return airlineRepo.save(existingAirline);
        } else {
            throw new RuntimeException("Airline not found with abbreviation: " + abbreviation);
        }
    }

    // Other business methods
}
