package com.baklykoff.controller;

import com.baklykoff.model.DAO.WorkerDao;
import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.models.Worker;

import java.util.Objects;

public class WorkerController implements com.baklykoff.controller.interfaces.WorkerController {

    private GeneralDao<Worker, Integer> workerDao;

    @Override
    public GeneralDao<Worker, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(workerDao, () -> workerDao = new WorkerDao());
    }
}
