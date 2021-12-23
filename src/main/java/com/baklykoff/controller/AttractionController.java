package com.baklykoff.controller;

import com.baklykoff.model.DAO.AttractionDao;
import com.baklykoff.model.models.Attraction;
import com.baklykoff.model.DAO.interfaces.GeneralDao;

import java.util.Objects;

public class AttractionController implements com.baklykoff.controller.interfaces.AttractionController {

    private GeneralDao<Attraction, Integer> attractionDao;

    @Override
    public GeneralDao<Attraction, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(attractionDao, () -> attractionDao = new AttractionDao());
    }
}
