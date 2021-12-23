package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.Park;
import org.baklykoff.rest.models.ShowEntertainment;
import org.baklykoff.rest.models.Ticket;
import org.baklykoff.rest.models.Visitor;

public class VisitorDto {
    private Visitor visitor;

    public VisitorDto(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getId() {
        return visitor.getId();
    }

    public String getFirstName() {
        return visitor.getFirstName();
    }

    public String getLastName() {
        return visitor.getLastName();
    }

    public Ticket getTicketId() {
        return visitor.getTicketId();
    }
}
