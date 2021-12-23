package org.baklykoff.rest.service;

import org.baklykoff.rest.models.Ticket;
import org.baklykoff.rest.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket addTicket(final Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(final Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(final Integer id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public void deleteTicketById(final Integer id) {
        ticketRepository.deleteById(id);
    }
}
