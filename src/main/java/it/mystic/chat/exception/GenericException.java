package it.mystic.chat.exception;

import it.mystic.chat.model.response.InvalidParam;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class GenericException extends ExecutionException {
    public GenericException(String message) {
        super(message);
    }
}
