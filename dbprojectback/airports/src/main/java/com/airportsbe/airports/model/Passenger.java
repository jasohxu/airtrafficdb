package com.airportsbe.airports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Passenger")
public class Passenger {

    @Id
    private Integer passengerID;
    private String name;
    private Date dateOfBirth;

    public Passenger() {
    }

    public Passenger(Integer passengerID, String name, Date dateOfBirth) {
        this.passengerID = passengerID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}