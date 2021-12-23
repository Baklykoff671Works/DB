package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.Park;
import org.baklykoff.rest.models.ShowEntertainment;
import org.baklykoff.rest.models.Worker;

import java.sql.Date;

public class WorkerDto {
    private Worker worker;

    public WorkerDto(Worker worker) {
        this.worker = worker;
    }

    public Integer getId() {
        return worker.getId();
    }

    public String getFirstName() {
        return worker.getFirstName();
    }

    public String getLastName() {
        return worker.getLastName();
    }

    public String getPosition() {
        return worker.getPosition();
    }

    public Integer getPassportNumber() {
        return worker.getPassportNumber();
    }

    public Float getSalary() {
        return worker.getSalary();
    }

    public Integer getPermision() {
        return worker.getPermision();
    }

    public Park getParkId() {
        return worker.getParkId();
    }

}
