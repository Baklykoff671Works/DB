package org.baklykoff.rest.controllers;

import org.baklykoff.rest.dto.VisitorDto;
import org.baklykoff.rest.exception.del.ItemFKException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.baklykoff.rest.models.Visitor;
import org.baklykoff.rest.service.VisitorService;
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
@RequestMapping(path = "/visitor")
public class VisitorController {
    private static final Logger LOGGER = LoggerFactory.getLogger( VisitorController.class);

    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public ResponseEntity<VisitorDto> createClient(@Valid @RequestBody final Visitor visitor) {
        LOGGER.info("Added new Visitor");
        return new ResponseEntity<VisitorDto>(new VisitorDto(visitorService.addVisitor(visitor)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VisitorDto> updateVisitor(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Visitor visitor) {

        if (visitorService.getVisitorById(id) == null) {
            LOGGER.error("Can't put(updateVisitor) an Visitor with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateVisitor) an Visitor with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Visitor with id: " + id);
        visitor.setId(id);
        return new ResponseEntity<VisitorDto>(new VisitorDto(visitorService.updateVisitor(visitor)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<VisitorDto>> getVisitors() {
        LOGGER.info("Gave away all Visitor");
        List<Visitor> Visitors = visitorService.getVisitors();
        List<VisitorDto> VisitorDtos = new ArrayList<>();
        for (Visitor visitor:Visitors) {
            VisitorDtos.add(new VisitorDto(visitor));
        }
        return new ResponseEntity<List<VisitorDto>>(VisitorDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VisitorDto> getVisitor(@PathVariable(name = "id") final Integer id) {
        if (visitorService.getVisitorById(id) == null) {
            LOGGER.error("Can't get(getVisitor) an Visitor with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getVisitor) an Visitor with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Visitor with id: " + id);
        return new ResponseEntity<VisitorDto>(new VisitorDto(visitorService.getVisitorById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Visitor> deleteVisitorById(@PathVariable("id") final Integer id) {
        if (visitorService.getVisitorById(id) == null) {
            LOGGER.error("Can't delete(deleteVisitorById) an Visitor with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteVisitorById) an Visitor with non-existing id: " + id);
        }


        try{
            visitorService.deleteVisitorById(id);
        }catch (Exception e) {
            throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
        }
        LOGGER.info("Successfully deleted Visitor with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
