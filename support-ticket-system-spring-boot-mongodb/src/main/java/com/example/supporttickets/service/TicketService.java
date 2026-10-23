package com.example.supporttickets.service;
import com.example.supporttickets.entity.Ticket;
import com.example.supporttickets.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Create a ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get one ticket
    public Optional<Ticket> getTicketById(String id) {
        return ticketRepository.findById(id);
    }

    // Update a ticket
    public Ticket updateTicket(String id, Ticket updatedTicket) {
        updatedTicket.setId(id);
        return ticketRepository.save(updatedTicket);
    }

    // Delete a ticket
    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }
}
