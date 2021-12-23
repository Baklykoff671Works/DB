package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.ShowEntertainmentDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.ShowEntertainment;
import org.baklykoff.rest.service.ShowEntertainmentService;
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
@RequestMapping(path = "/show_entertainment")
public class ShowEntertainmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowEntertainmentController.class);

    @Autowired
    private ShowEntertainmentService showEntertainmentService;

    @PostMapping
    public ResponseEntity<ShowEntertainmentDto> createShowEntertainment(@Valid @RequestBody final ShowEntertainment showEntertainment) {
        LOGGER.info("Added new ShowEntertainment");
        return new ResponseEntity<ShowEntertainmentDto>(new ShowEntertainmentDto(showEntertainmentService.addShowEntertainment(showEntertainment)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ShowEntertainmentDto> updateShowEntertainment(
            @PathVariable("id") final int id,
            @Valid @RequestBody final ShowEntertainment showEntertainment) {

        if (showEntertainmentService.getShowEntertainmentById(id) == null) {
            LOGGER.error("Can't put(updateShowEntertainment) an ShowEntertainment with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateShowEntertainment) an ShowEntertainment with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated ShowEntertainment with id: " + id);
        showEntertainment.setId(id);
        return new ResponseEntity<ShowEntertainmentDto>(new ShowEntertainmentDto(showEntertainmentService.updateShowEntertainment(showEntertainment)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShowEntertainmentDto>> getShowEntertainments() {
        LOGGER.info("Gave away all ShowEntertainment");
        List<ShowEntertainment> showEntertainments = showEntertainmentService.getShowEntertainments();
        List<ShowEntertainmentDto> showEntertainmentsDto = new ArrayList<>();
        for (ShowEntertainment showEntertainment : showEntertainments) {
            showEntertainmentsDto.add(new ShowEntertainmentDto(showEntertainment));
        }
        return new ResponseEntity<List<ShowEntertainmentDto>>(showEntertainmentsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ShowEntertainmentDto> getShowEntertainment(@PathVariable(name = "id") final Integer id) {
        if (showEntertainmentService.getShowEntertainmentById(id) == null) {
            LOGGER.error("Can't get(ShowEntertainment) an ShowEntertainment with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(ShowEntertainment) an ShowEntertainment with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an ShowEntertainment with id: " + id);
        return new ResponseEntity<ShowEntertainmentDto>(new ShowEntertainmentDto(showEntertainmentService.getShowEntertainmentById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ShowEntertainment> deleteShowEntertainmentById(@PathVariable("id") final Integer id) {
        if (showEntertainmentService.getShowEntertainmentById(id) == null) {
            LOGGER.error("Can't delete(ShowEntertainment) an ShowEntertainment with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(ShowEntertainment) an ShowEntertainment with non-existing id: " + id);
        }
        try{
            showEntertainmentService.deleteShowEntertainmentById(id);
        } catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted ShowEntertainment with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
