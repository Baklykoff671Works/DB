package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.PaydeskDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.Paydesk;
import org.baklykoff.rest.service.PaydeskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/parcel")
public class PaydeskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaydeskController.class);

    @Autowired
    private PaydeskService paydeskService;

    @PostMapping
    public ResponseEntity<PaydeskDto> createPaydesk(@Valid @RequestBody final Paydesk paydesk) {
        LOGGER.info("Added new Paydesk");
        return new ResponseEntity<PaydeskDto>(new PaydeskDto(paydeskService.addPaydesk(paydesk)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PaydeskDto> updatePaydesk(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Paydesk paydesk) {

        if (paydeskService.getPaydeskById(id) == null) {
            LOGGER.error("Can't put(updatePaydesk) an Paydesk with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updatePaydesk) an Paydesk with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Paydesk with id: " + id);
        paydesk.setId(id);
        return new ResponseEntity<PaydeskDto>(new PaydeskDto(paydeskService.updatePaydesk(paydesk)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PaydeskDto>> getPaydesks() {
        LOGGER.info("Gave away all Paydesks");
        List<Paydesk> paydesks = paydeskService.getPaydesks();
        List<PaydeskDto> paydesksDto = new ArrayList<>();
        for (Paydesk paydesk : paydesks) {
            paydesksDto.add(new PaydeskDto(paydesk));
        }
        return new ResponseEntity<List<PaydeskDto>>(paydesksDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaydeskDto> getPaydesk(@PathVariable(name = "id") final Integer id) {
        if (paydeskService.getPaydeskById(id) == null) {
            LOGGER.error("Can't get(getPaydesks) an Paydesks with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getPaydesks) an Paydesks with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Paydesks with id: " + id);
        return new ResponseEntity<PaydeskDto>(new PaydeskDto(paydeskService.getPaydeskById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Paydesk> deletePaydeskById(@PathVariable("id") final Integer id) {
        if (paydeskService.getPaydeskById(id) == null) {
            LOGGER.error("Can't delete(deletePaydeskById) an Paydesk with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deletePaydeskById) an Paydesk with non-existing id: " + id);
        }

        try{
            paydeskService.deletePaydeskById(id);
        } catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted Paydesk with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
