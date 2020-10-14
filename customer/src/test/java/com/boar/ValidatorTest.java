package com.boar;

import org.junit.Assert;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class ValidatorTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void compareExpectedToActualValidateErrors(int numberOfErrors, Object object) {
        Assert.assertEquals(numberOfErrors, validator.validate(object).size());
    }
}
