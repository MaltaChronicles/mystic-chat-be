package it.mystic.chat.exception;

import java.util.concurrent.ExecutionException;


public class GenericException extends ExecutionException {
    public GenericException(String message) {
        super(message);
    }
}
