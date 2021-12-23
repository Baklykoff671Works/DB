package org.baklykoff.rest.exception.del;

public class ItemFKException extends RuntimeException{

    public ItemFKException(String message) {
        super(message);
    }

    public ItemFKException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
