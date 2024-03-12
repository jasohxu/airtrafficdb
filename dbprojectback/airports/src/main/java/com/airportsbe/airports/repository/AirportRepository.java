package com.airportsbe.airports.repository;

import com.airportsbe.airports.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Airport findByAbbreviation(String abbreviation);
}