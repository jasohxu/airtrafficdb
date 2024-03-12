package com.airportsbe.airports.repository;

import com.airportsbe.airports.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Passenger findByPassengerID(Integer passengerID);
}