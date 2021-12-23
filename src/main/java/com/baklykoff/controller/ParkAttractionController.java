package com.baklykoff.controller;

import com.baklykoff.model.DAO.ParkAttractionDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.ParkAttraction;

import java.util.Objects;

public class ParkAttractionController implements com.baklykoff.controller.interfaces.ParkAttractionController {

    private GeneralDao<ParkAttraction, Integer> parkAttractionDao;

    @Override
    public GeneralDao<ParkAttraction, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(parkAttractionDao, () -> parkAttractionDao = new ParkAttractionDao());
    }
}
