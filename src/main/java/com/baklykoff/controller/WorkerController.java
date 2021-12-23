package com.baklykoff.controller;

import com.baklykoff.model.DAO.interfaces.GeneralDao;
import com.baklykoff.model.DAO.WorkerDao;
import com.baklykoff.model.models.Worker;

import java.util.Objects;

public class WorkerController implements com.baklykoff.controller.interfaces.WorkerController {

    private GeneralDao<Worker, Integer> workerDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-30s | %-30s | %-20s | %-20s | %-97s |",
                "id", "firstName", "lastName", "position", "passportNumber", "salary", "permision", "parkId");
    }

    @Override
    public GeneralDao<Worker, Integer> generalDao() {
        return Objects.requireNonNullElseGet(workerDao, () -> workerDao = new WorkerDao());
    }
}
