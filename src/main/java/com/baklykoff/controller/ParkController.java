package com.baklykoff.controller;

import com.baklykoff.model.DAO.ParkDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.Park;

import java.util.Objects;

public class ParkController implements com.baklykoff.controller.interfaces.ParkController {

    private GeneralDao<Park, Integer> parkDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |","id","name","visitors","location","maxVisitors");
    }

    @Override
    public GeneralDao<Park, Integer> generalDao() {
        return Objects.requireNonNullElseGet(parkDao, () -> parkDao = new ParkDao());
    }
}
