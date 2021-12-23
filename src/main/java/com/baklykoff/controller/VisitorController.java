package com.baklykoff.controller;

import com.baklykoff.model.DAO.VisitorDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.Visitor;
import java.util.Objects;

public class VisitorController implements com.baklykoff.controller.interfaces.VisitorController {

    private GeneralDao<Visitor, Integer> visitorDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-97s | %-103s | %-119s |","id","firstName","lastName","ticketId","park","attraction");
    }

    @Override
    public GeneralDao<Visitor, Integer> generalDao() {
        return Objects.requireNonNullElseGet(visitorDao,() -> visitorDao = new VisitorDao());
    }
}
