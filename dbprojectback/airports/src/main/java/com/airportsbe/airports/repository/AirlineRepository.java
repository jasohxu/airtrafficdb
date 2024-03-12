package com.airportsbe.airports.repository;

import com.airportsbe.airports.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, String> {
    Airline findByAbbreviation(String abbreviation);
}