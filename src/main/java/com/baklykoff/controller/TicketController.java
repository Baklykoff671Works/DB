package com.baklykoff.controller;

import com.baklykoff.model.DAO.TicketDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.Ticket;

import java.util.Objects;

public class TicketController implements com.baklykoff.controller.interfaces.TicketController {

    private GeneralDao<Ticket, Integer> ticketDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-225s |",
                "id",
                "expirationDate",
                "startDate",
                "isVip",
                "price",
                "parkAttractionId");
    }

    @Override
    public GeneralDao<Ticket, Integer> generalDao() {
        return Objects.requireNonNullElseGet(ticketDao,() -> ticketDao = new TicketDao());
    }
}
