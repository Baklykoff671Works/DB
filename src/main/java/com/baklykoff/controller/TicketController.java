package com.baklykoff.controller;

import com.baklykoff.model.DAO.TicketDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.DAO.WorkerDao;
import com.baklykoff.model.models.Ticket;
import com.baklykoff.model.models.Worker;

import java.util.Objects;

public class TicketController implements com.baklykoff.controller.interfaces.TicketController {

    private GeneralDao<Ticket, Integer> ticketDao;

    @Override
    public GeneralDao<Ticket, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(ticketDao,() -> ticketDao = new TicketDao());
    }
}
