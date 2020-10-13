package com.boar.model.dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

class IdentityDocumentTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void firstTest() {
        IdentityDocumentDTO identityDocumentDTO1 = new IdentityDocumentDTO();
        IdentityDocumentDTO identityDocumentDTO2 = new IdentityDocumentDTO();
        IdentityDocumentDTO identityDocumentDTO3 = new IdentityDocumentDTO();

        identityDocumentDTO1.setExpirationDate(LocalDate.of(2030, 12, 12));
        identityDocumentDTO2.setExpirationDate(LocalDate.of(2022, 1, 1));
        identityDocumentDTO3.setExpirationDate(LocalDate.of(2020, 10, 30));

        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation1 = validator.validate(identityDocumentDTO1);
        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation2 = validator.validate(identityDocumentDTO2);
        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation3 = validator.validate(identityDocumentDTO3);

        Assert.assertEquals(0, constraintViolation1.size());
        Assert.assertEquals(0, constraintViolation2.size());
        Assert.assertEquals(0, constraintViolation3.size());
    }

    @Test
    public void secondTest() {
        IdentityDocumentDTO identityDocumentDTO1 = new IdentityDocumentDTO();
        IdentityDocumentDTO identityDocumentDTO2 = new IdentityDocumentDTO();
        IdentityDocumentDTO identityDocumentDTO3 = new IdentityDocumentDTO();

        identityDocumentDTO1.setExpirationDate(LocalDate.of(2000, 12, 12));
        identityDocumentDTO2.setExpirationDate(LocalDate.of(2020, 1, 1));
        identityDocumentDTO3.setExpirationDate(LocalDate.of(1999, 10, 30));

        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation1 = validator.validate(identityDocumentDTO1);
        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation2 = validator.validate(identityDocumentDTO2);
        Set<ConstraintViolation<IdentityDocumentDTO>> constraintViolation3 = validator.validate(identityDocumentDTO3);

        Assert.assertNotEquals(0, constraintViolation1.size());
        Assert.assertNotEquals(0, constraintViolation2.size());
        Assert.assertNotEquals(0, constraintViolation3.size());
    }
}