package org.baklykoff.rest.exception.del;

import org.baklykoff.rest.exception.ItemException;
import org.baklykoff.rest.exception.not.found.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ItemFXExceptionHandler {
    @ExceptionHandler(ItemFKException.class)
    public ResponseEntity<Object> handleItemFKException(final ItemFKException e) {
        ItemException itemException = new ItemException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(itemException, HttpStatus.BAD_REQUEST);
    }
}
