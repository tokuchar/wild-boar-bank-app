package com.boar;

import com.boar.service.ValidatorService;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class ValidatorTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();
    private final ValidatorService validatorService = new ValidatorService();

    public void compareExpectedToActualValidateErrors(int numberOfErrors, Object object) {
        assertEquals(numberOfErrors, validator.validate(object).size());
    }

    public void validateWithUsesMethodCheckIfIdentityIsCorrect(String objectToValidate) {
        assertTrue(validatorService.checkIfIdentityIsCorrect(objectToValidate));
    }

    public void invalidateWithUsesMethodCheckIfIdentityIsCorrect(String objectToValidate) {
        assertFalse(validatorService.checkIfIdentityIsCorrect(objectToValidate));
    }
}
