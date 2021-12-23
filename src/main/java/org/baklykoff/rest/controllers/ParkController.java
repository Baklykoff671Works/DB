package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.ParkDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.Park;
import org.baklykoff.rest.service.ParkService;
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
@RequestMapping(path = "/park")
public class ParkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParkController.class);

    @Autowired
    private ParkService parkService;

    @PostMapping
    public ResponseEntity<ParkDto> createPark(@Valid @RequestBody final Park park) {
        LOGGER.info("Added new Park");
        parkService.addPark(park);
        return new ResponseEntity<ParkDto>(new ParkDto(park), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ParkDto> updatePark(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Park park) {

        if (parkService.getParkById(id) == null) {
            LOGGER.error("Can't put(updatePark) an Park with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updatePark) an Park with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Park with id: " + id);
        park.setId(id);
        parkService.updatePark(park);
        return new ResponseEntity<ParkDto>(new ParkDto(park), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ParkDto>> getParks() {
        LOGGER.info("Gave away all Park");
        List<Park> park = parkService.getParks();
        List<ParkDto> parkDto = new ArrayList<>();
        for (Park del: park) {
            ParkDto parksDto = new ParkDto(del);
            parkDto.add(parksDto);
        }
        return new ResponseEntity<List<ParkDto>>(parkDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParkDto> getPark(@PathVariable(name = "id") final Integer id) {
        if (parkService.getParkById(id) == null) {
            LOGGER.error("Can't get(getPark) an Park with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getPark) an Park with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Park with id: " + id);
        return new ResponseEntity<ParkDto>(new ParkDto(parkService.getParkById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Park> deleteParkById(@PathVariable("id") final Integer id) {
        if (parkService.getParkById(id) == null) {
            LOGGER.error("Can't delete(deleteParkById) an Park with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteParkById) an Park with non-existing id: " + id);
        }


        try{
            parkService.deleteParkById(id);
        } catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted Park with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
