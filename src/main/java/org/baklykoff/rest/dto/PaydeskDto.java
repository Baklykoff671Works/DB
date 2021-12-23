package org.baklykoff.rest.dto;

import org.baklykoff.rest.models.Attraction;
import org.baklykoff.rest.models.Park;
import org.baklykoff.rest.models.Paydesk;

public class PaydeskDto {

    private Paydesk paydesk;

    public PaydeskDto(Paydesk paydesk) {
        this.paydesk = paydesk;
    }

    public Integer getId() {
        return paydesk.getId();
    }

    public Attraction getAttractionId() {
        return paydesk.getAttractionId();
    }

    public Integer getHasTicket() {
        return paydesk.getHasTicket();
    }

    public Park getParkId() {
        return paydesk.getParkId();
    }
}
