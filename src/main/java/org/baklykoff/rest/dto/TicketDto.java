package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.*;

import java.sql.Date;

public class TicketDto {
    private Ticket ticket;

    public TicketDto(Ticket ticket) {
        this.ticket = ticket;
    }

    public Integer getId() {
        return ticket.getId();
    }

    public Date getExpirationDate() {
        return ticket.getExpirationDate();
    }

    public Date getStartDate() {
        return ticket.getStartDate();
    }

    public Integer getIsVip() {
        return ticket.getIsVip();
    }

    public Float getPrice() {
        return ticket.getPrice();
    }

    public ParkAttraction getParkAttractionId() {
        return ticket.getParkAttractionId();
    }
}
