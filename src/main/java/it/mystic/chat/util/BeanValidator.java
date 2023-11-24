package it.mystic.chat.util;

import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.model.response.InvalidParam;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Getter
public class BeanValidator {

    Set<ConstraintViolation<Object>> violations;
    public  void validate(Object object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        violations = validator.validate(object);

        if (!violations.isEmpty()) {
            throw new ValidationException(getViolations().stream().map(violation -> {
                return new InvalidParam(violation.getPropertyPath().toString(), violation.getMessage());
            }).toList());
        }
    }
}
