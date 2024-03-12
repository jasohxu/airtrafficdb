package com.airportsbe.airports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airportsbe.airports.model.Passenger;
import com.airportsbe.airports.repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository PassengerRepo;

    public List<Passenger> findAll() {
        return PassengerRepo.findAll();
    }

    public Passenger findByPassengerID(Integer passengerID) {
        return PassengerRepo.findByPassengerID(passengerID);
    }

    public Passenger savePassenger(Passenger passenger) {
        return PassengerRepo.save(passenger);
    }

    public void deletePassenger(Integer passengerID) {
        PassengerRepo.deleteById(passengerID);
    }

    @Transactional
    public Passenger updatePassenger(Integer passengerID, Passenger passengerDetails) {
        Optional<Passenger> PassengerOptional = PassengerRepo.findById(passengerID);

        if (PassengerOptional.isPresent()) {
            Passenger existingPassenger = PassengerOptional.get();

            if(passengerDetails.getName() != null) {
                existingPassenger.setName(passengerDetails.getName());
            }

            if(passengerDetails.getDateOfBirth() != null) {
                existingPassenger.setDateOfBirth(passengerDetails.getDateOfBirth());
            }

            return PassengerRepo.save(existingPassenger);
        } else {
            throw new RuntimeException("Passenger not found with ID: " + passengerID);
        }
    }
}
