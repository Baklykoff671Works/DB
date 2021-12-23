package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.ParkAttractionDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.ParkAttraction;
import org.baklykoff.rest.service.ParkAttractionService;
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
@RequestMapping(path = "/park_attraction")
public class ParkAttractionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParkAttractionController.class);

    @Autowired
    private ParkAttractionService parkAttractionService;

    @PostMapping
    public ResponseEntity<ParkAttractionDto> createParkAttraction(@Valid @RequestBody final ParkAttraction parkAttraction) {
        LOGGER.info("Added new ParkAttraction");
        return new ResponseEntity<ParkAttractionDto>(new ParkAttractionDto(parkAttractionService.addParkAttraction(parkAttraction)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ParkAttractionDto> updateParkAttraction(
            @PathVariable("id") final int id,
            @Valid @RequestBody final ParkAttraction parkAttraction) {

        if (parkAttractionService.getParkAttractionById(id) == null) {
            LOGGER.error("Can't put(updateParkAttraction) an ParkAttraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateParkAttraction) an ParkAttraction with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated ParkAttraction with id: " + id);
        parkAttraction.setId(id);
        return new ResponseEntity<ParkAttractionDto>(new ParkAttractionDto(parkAttractionService.updateParkAttraction(parkAttraction)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ParkAttractionDto>> getParkAttractions() {
        LOGGER.info("Gave away all Indents");
        List<ParkAttraction> parkAttractions = parkAttractionService.getParkAttractions();
        List<ParkAttractionDto> parkAttractionsDto = new ArrayList<>();
        for (ParkAttraction parkAttraction : parkAttractions) {
            parkAttractionsDto.add(new ParkAttractionDto(parkAttraction));
        }
        return new ResponseEntity<List<ParkAttractionDto>>(parkAttractionsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParkAttractionDto> getParkAttraction(@PathVariable(name = "id") final Integer id) {
        if (parkAttractionService.getParkAttractionById(id) == null) {
            LOGGER.error("Can't get(getParkAttraction) an ParkAttraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getParkAttraction) an ParkAttraction with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an ParkAttraction with id: " + id);
        return new ResponseEntity<ParkAttractionDto>(new ParkAttractionDto(parkAttractionService.getParkAttractionById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ParkAttraction> deleteParkAttractionById(@PathVariable("id") final Integer id) {
        if (parkAttractionService.getParkAttractionById(id) == null) {
            LOGGER.error("Can't delete(deleteParkAttractionById) an ParkAttraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteParkAttractionById) an ParkAttraction with non-existing id: " + id);
        }

        try{
            parkAttractionService.deleteParkAttractionById(id);
        } catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted ParkAttraction with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
