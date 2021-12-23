package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.TicketDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.Ticket;
import org.baklykoff.rest.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {
    private static final Logger LOGGER = LoggerFactory.getLogger( TicketController.class);

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createClient(@Valid @RequestBody final Ticket ticket) {
        LOGGER.info("Added new Ticket");
        return new ResponseEntity<TicketDto>(new TicketDto(ticketService.addTicket(ticket)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TicketDto> updateTicket(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Ticket ticket) {

        if (ticketService.getTicketById(id) == null) {
            LOGGER.error("Can't put(updateTicket) an Ticket with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateTicket) an Ticket with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Ticket with id: " + id);
        ticket.setId(id);
        return new ResponseEntity<TicketDto>(new TicketDto(ticketService.updateTicket(ticket)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getTickets() {
        LOGGER.info("Gave away all Ticket");
        List<Ticket> Tickets = ticketService.getTickets();
        List<TicketDto> TicketDtos = new ArrayList<>();
        for (Ticket ticket:Tickets) {
            TicketDtos.add(new TicketDto(ticket));
        }
        return new ResponseEntity<List<TicketDto>>(TicketDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable(name = "id") final Integer id) {
        if (ticketService.getTicketById(id) == null) {
            LOGGER.error("Can't get(getTicket) an Ticket with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getTicket) an Ticket with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Ticket with id: " + id);
        return new ResponseEntity<TicketDto>(new TicketDto(ticketService.getTicketById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable("id") final Integer id) {
        if (ticketService.getTicketById(id) == null) {
            LOGGER.error("Can't delete(deleteTicketById) an Ticket with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteTicketById) an Ticket with non-existing id: " + id);
        }

        try{
            ticketService.deleteTicketById(id);
        }catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted Ticket with id: " + id);
        return ResponseEntity.noContent().build();
    }
}