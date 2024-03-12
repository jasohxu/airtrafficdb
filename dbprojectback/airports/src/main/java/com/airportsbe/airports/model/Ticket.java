package com.airportsbe.airports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    private Integer ticketID;
    private Integer passengerID;
    private Integer flightNumber;
    private Date flightDate;

    public Ticket() {
    }

    public Ticket(Integer ticketID, Integer passengerID, Integer flightNumber, Date flightDate) {
        this.ticketID = ticketID;
        this.passengerID = passengerID;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
}