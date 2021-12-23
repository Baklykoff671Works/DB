package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.Park;
import org.baklykoff.rest.models.ShowEntertainment;

public class ShowEntertainmentDto {
    private ShowEntertainment showEntertainment;

    public ShowEntertainmentDto(ShowEntertainment showEntertainment) {
        this.showEntertainment = showEntertainment;
    }

    public Integer getId() {
        return showEntertainment.getId();
    }

    public String getDescription() {
        return showEntertainment.getDescription();
    }

    public Park getParkId() {
        return showEntertainment.getParkId();
    }

}
