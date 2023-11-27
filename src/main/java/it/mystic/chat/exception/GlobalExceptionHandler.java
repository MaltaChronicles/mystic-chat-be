package it.mystic.chat.exception;

import it.mystic.chat.model.response.InvalidParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<InvalidParam>> handleException(ValidationException e) {
        return ResponseEntity.badRequest().body(e.getViolations());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<String> handleException(GenericException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
