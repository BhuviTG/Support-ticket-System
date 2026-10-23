package com.example.supporttickets.repository;
import com.example.supporttickets.entity.Ticket;
import com.example.supporttickets.entity.TicketStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface TicketRepository extends MongoRepository<Ticket,String> {
 List<Ticket> findByStatus(TicketStatus status);
 List<Ticket> findByRequesterEmailIgnoreCase(String requesterEmail);
}
