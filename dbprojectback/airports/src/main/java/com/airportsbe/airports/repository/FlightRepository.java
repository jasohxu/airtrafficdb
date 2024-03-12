package com.airportsbe.airports.repository;

import com.airportsbe.airports.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(Integer flightNumber);
}