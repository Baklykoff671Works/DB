package org.baklykoff.rest.dto;
import org.baklykoff.rest.models.Park;

public class ParkDto {
    private Park park;

    public ParkDto(Park park) {
        this.park = park;
    }

    public Integer getId() {
        return park.getId();
    }

    public String getName() {
        return park.getName();
    }

    public Integer getVisitors() {
        return park.getVisitors();
    }

    public String getLocation() {
        return park.getLocation();
    }

    public Integer getMaxVisitors() {
        return park.getMaxVisitors();
    }
}
