package com.baklykoff.controller;

import com.baklykoff.model.DAO.ShowEntertainmentDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.ShowEntertainment;

import java.util.Objects;

public class ShowEntertainmentController implements com.baklykoff.controller.interfaces.ShowEntertainmentController {

    private GeneralDao<ShowEntertainment, Integer>  showEntertainmentDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-45s | %-97s |", "id", "description","parkId");
    }

    @Override
    public GeneralDao<ShowEntertainment, Integer> generalDao() {
        return Objects.requireNonNullElseGet(showEntertainmentDao, () -> showEntertainmentDao = new ShowEntertainmentDao());
    }
}
