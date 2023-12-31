package it.mystic.chat.exception;

import it.mystic.chat.model.response.InvalidParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends jakarta.validation.ValidationException {

    private List<InvalidParam> violations;

    public ValidationException(String param, String message) {
        this.violations = Collections.singletonList(new InvalidParam(param, message));
    }

}
