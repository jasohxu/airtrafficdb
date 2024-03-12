package com.airportsbe.airports.repository;

import com.airportsbe.airports.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findByTicketID(Integer ticketID);
}