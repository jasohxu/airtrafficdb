package com.airportsbe.airports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airportsbe.airports.model.Ticket;
import com.airportsbe.airports.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository TicketRepo;

    public List<Ticket> findAll() {
        return TicketRepo.findAll();
    }

    public Ticket findByTicketID(Integer ticketID) {
        return TicketRepo.findByTicketID(ticketID);
    }

    public Ticket saveTicket(Ticket ticket) {
        return TicketRepo.save(ticket);
    }

    public void deleteTicket(Integer ticketID) {
        TicketRepo.deleteById(ticketID);
    }

    @Transactional
    public Ticket updateTicket(Integer ticketID, Ticket ticketDetails) {
        Optional<Ticket> TicketOptional = TicketRepo.findById(ticketID);

        if (TicketOptional.isPresent()) {
            Ticket existingTicket = TicketOptional.get();

            if(ticketDetails.getPassengerID() != null) {
                existingTicket.setPassengerID(ticketDetails.getPassengerID());
            }

            if(ticketDetails.getFlightNumber() != null) {
                existingTicket.setFlightNumber(ticketDetails.getFlightNumber());
            }

            if(ticketDetails.getFlightDate() != null) {
                existingTicket.setFlightDate(ticketDetails.getFlightDate());
            }

            return TicketRepo.save(existingTicket);
        } else {
            throw new RuntimeException("Ticket not found with ID: " + ticketID);
        }
    }
}