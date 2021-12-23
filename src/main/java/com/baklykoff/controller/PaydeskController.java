package com.baklykoff.controller;

import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.DAO.PaydeskDao;
import com.baklykoff.model.models.Paydesk;

import java.util.Objects;

public class PaydeskController implements com.baklykoff.controller.interfaces.PaydeskController {

    private GeneralDao<Paydesk, Integer> paydeskDao;

    @Override
    public GeneralDao<Paydesk, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(paydeskDao,() -> paydeskDao = new PaydeskDao());
    }
}
