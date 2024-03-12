package com.airportsbe.airports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Airport")
public class Airport {

    @Id
    private String abbreviation;
    private String fullName;
    private String city;

    // Constructors, getters, and setters
    public Airport() {
    }
    
    public Airport(String abbreviation, String fullName, String city) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.city = city;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
