package com.airportsbe.airports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    private Integer flightNumber;
    private String airline;
    private String origin;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;

    public Flight() {
    }

    public Flight(Integer flightNumber, String airline, String origin, String destination, Date departureTime, Date arrivalTime) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTimeString) {
        this.departureTime = parseTime(departureTimeString);
    }

    public void setArrivalTime(String arrivalTimeString) {
        this.arrivalTime = parseTime(arrivalTimeString);
    }

    private Date parseTime(String timeString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDepartureTime() {
        return formatTime(this.departureTime);
    }

    public String getArrivalTime() {
        return formatTime(this.arrivalTime);
    }

    private String formatTime(Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(date);
        } else {
            return null;
        }
    }
}