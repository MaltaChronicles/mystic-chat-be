package it.mystic.chat.exception;

import it.mystic.chat.model.response.InvalidParam;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ValidationException extends RuntimeException {

    private List<InvalidParam> violations;

    public ValidationException(List<InvalidParam> violations) {
        this.violations = violations;
    }

    public ValidationException(InvalidParam violation) {
        this.violations = Collections.singletonList(violation);
    }

    public ValidationException(String param, String message) {
        this.violations = Collections.singletonList(new InvalidParam(param, message));
    }

}
