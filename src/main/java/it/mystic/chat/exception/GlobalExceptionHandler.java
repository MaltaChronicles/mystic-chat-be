package it.mystic.chat.exception;

import it.mystic.chat.model.response.InvalidParam;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<InvalidParam>> handleException(ValidationException e) {
        log.error(String.valueOf(e));
        return ResponseEntity.badRequest().body(e.getViolations());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<String> handleException(GenericException e) {
        log.error(String.valueOf(e));
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleException(MethodArgumentTypeMismatchException e) {
        log.error(String.valueOf(e));
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(EntityNotFoundException e) {
        log.error(String.valueOf(e));
        return ResponseEntity.badRequest().body("Id non trovato!");
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleException(SQLIntegrityConstraintViolationException e) {
        log.error(String.valueOf(e));
        return ResponseEntity.badRequest().body("Id non trovato!");
    }

}
