package com.example.supporttickets.controller;


import com.example.supporttickets.entity.Ticket;
import com.example.supporttickets.service.TicketService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Create a ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    // Get all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Get a ticket by ID
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable String id) {
        return ticketService.getTicketById(id)
                .orElseThrow(() ->
                    new RuntimeException("Ticket not found"));
    }

    // Update a ticket
    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable String id,
            @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
    }
}
