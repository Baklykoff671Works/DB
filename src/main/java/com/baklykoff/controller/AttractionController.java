package com.baklykoff.controller;

import com.baklykoff.model.DAO.AttractionDao;
import com.baklykoff.model.models.Attraction;
import com.baklykoff.model.DAO.interfaces.GeneralDao;

import java.util.Objects;

public class AttractionController implements com.baklykoff.controller.interfaces.AttractionController {

    private GeneralDao<Attraction, Integer> attractionDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-40s | %-20s | %-20s | %-20s |","id", "name", "maxVisitors", "minPermision", "hasOptionVip");
    }

    @Override
    public GeneralDao<Attraction, Integer> generalDao() {
        return Objects.requireNonNullElseGet(attractionDao, () -> attractionDao = new AttractionDao());
    }

}
