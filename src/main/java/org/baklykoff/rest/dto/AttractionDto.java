package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.Attraction;

public class AttractionDto {
    private Attraction attraction;

    public AttractionDto(Attraction attraction) {
        this.attraction = attraction;
    }

    public Integer getId() {
        return attraction.getId();
    }

    public String getName() {
        return attraction.getName();
    }

    public Integer getMaxVisitors() {
        return attraction.getMaxVisitors();
    }

    public Integer getMinPermision() {
        return attraction.getMinPermision();
    }

    public Integer getHasOptionVip() {
        return attraction.getHasOptionVip();
    }
}
