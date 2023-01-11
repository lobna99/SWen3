package at.fhtw.swen3.services.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Slf4j
public class Validator {
    static ValidatorFactory getValidatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }


    javax.validation.Validator getValidator() {
        return getValidatorFactory().getValidator();
    }

    public <T> void validate(T o) {
        javax.validation.Validator validator = getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(o);
        violations.forEach(v -> log.error(v.getMessage()));
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}