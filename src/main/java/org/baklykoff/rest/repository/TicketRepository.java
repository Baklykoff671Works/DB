package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
