package com.baklykoff.controller;

import com.baklykoff.model.DAO.ParkDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.DAO.TicketDao;
import com.baklykoff.model.models.Park;
import com.baklykoff.model.models.Ticket;

import java.util.Objects;

public class ParkController implements com.baklykoff.controller.interfaces.ParkController {

    private GeneralDao<Park, Integer> parkDao;

    @Override
    public GeneralDao<Park, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(parkDao, () -> parkDao = new ParkDao());
    }

}
