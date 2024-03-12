package com.airportsbe.airports.controller;

import com.airportsbe.airports.model.Ticket;
import com.airportsbe.airports.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @GetMapping("/{ticketID}")
    public ResponseEntity<Ticket> getTicketByTicketID(@PathVariable Integer ticketID) {
        Ticket ticket = ticketService.findByTicketID(ticketID);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    @PutMapping("/{ticketID}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer ticketID, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = ticketService.updateTicket(ticketID, ticketDetails);
        return updatedTicket != null ? ResponseEntity.ok(updatedTicket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{ticketID}")
    public ResponseEntity<?> deleteTicket(@PathVariable Integer ticketID) {
        ticketService.deleteTicket(ticketID);
        return ResponseEntity.ok().build();
    }

    // Other CRUD endpoints
}