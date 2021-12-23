package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.AttractionDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.Attraction;
import org.baklykoff.rest.service.AttractionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/attraction")
public class AttractionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttractionController.class);

    @Autowired
    private AttractionService attractionService;

    @PostMapping
    public ResponseEntity<AttractionDto> createAttraction(@Valid @RequestBody final Attraction attraction) {
        attractionService.addAttraction(attraction);
        LOGGER.info("Added new attraction");
        return new ResponseEntity<AttractionDto>(new AttractionDto(attraction), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AttractionDto> updateAttraction(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Attraction attraction) {

        if (attractionService.getAttractionById(id) == null) {
            LOGGER.error("Can't put(updateAttraction) an attraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateAttraction) an attraction with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated attraction with id: " + id);
        attraction.setId(id);
        attractionService.updateAttraction(attraction);
        return new ResponseEntity<AttractionDto>(new AttractionDto(attraction), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AttractionDto>> getAttractions() {
        LOGGER.info("Gave away all Attractions");
        List<Attraction> attractions = attractionService.getAttractions();
        List<AttractionDto> attractionsDto = new ArrayList<>();
        for (Attraction attraction : attractions) {
            AttractionDto attractionDto = new AttractionDto(attraction);
            attractionsDto.add(attractionDto);
        }
        return new ResponseEntity<List<AttractionDto>>(attractionsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AttractionDto> getAttraction(@PathVariable(name = "id") final Integer id) {
        if (attractionService.getAttractionById(id) == null) {
            LOGGER.error("Can't get(getAttraction) an Attraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getAttraction) an Attraction with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Attraction with id: " + id);
        Attraction attraction = attractionService.getAttractionById(id);
        return new ResponseEntity<AttractionDto>(new AttractionDto(attraction), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Attraction> deleteAttractionById(@PathVariable("id") final Integer id) {
        if (attractionService.getAttractionById(id) == null) {
            LOGGER.error("Can't delete(deleteAttractionById) an Attraction with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteAttractionById) an Attraction with non-existing id: " + id);
        }
        try {
            attractionService.deleteAttractionById(id);
        } catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }

        LOGGER.info("Successfully deleted Attraction with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
