package com.baklykoff.controller;

import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.DAO.ShowEntertainmentDao;
import com.baklykoff.model.models.ShowEntertainment;

import java.util.Objects;

public class ShowEntertainmentController implements com.baklykoff.controller.interfaces.ShowEntertainmentController {

    private GeneralDao<ShowEntertainment, Integer>  showEntertainmentDao;

    @Override
    public GeneralDao<ShowEntertainment, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(showEntertainmentDao,() -> showEntertainmentDao = new ShowEntertainmentDao());
    }
}
