package com.baklykoff.controller;

import com.baklykoff.model.DAO.VisitorDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.Visitor;

import java.util.Objects;

public class VisitorController implements com.baklykoff.controller.interfaces.VisitorController {

    private GeneralDao<Visitor, Integer> visitorDao;

    @Override
    public GeneralDao<Visitor, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(visitorDao,() -> visitorDao = new VisitorDao());
    }
}