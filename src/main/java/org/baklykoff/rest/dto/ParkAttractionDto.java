package org.baklykoff.rest.dto;
import org.baklykoff.rest.models.*;

public class ParkAttractionDto {

    private ParkAttraction parkAttraction;

    public ParkAttractionDto(ParkAttraction parkAttraction) {
        this.parkAttraction = parkAttraction;
    }

    public Integer getId() {
        return parkAttraction.getId();
    }

    public Park getParkId() {
        return parkAttraction.getParkId();
    }

    public Attraction getAttractionId() {
        return parkAttraction.getAttractionId();
    }
}
