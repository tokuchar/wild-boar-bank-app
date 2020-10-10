package com.boar.model.dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

class ContactDTOTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void firstTest() {
        ContactDTO contactDTO1 = new ContactDTO();
        ContactDTO contactDTO2 = new ContactDTO();
        ContactDTO contactDTO3 = new ContactDTO();

        contactDTO1.setContactValue("doktor98@gmail.com");
        contactDTO2.setContactValue("doktor98@onet.pl");
        contactDTO3.setContactValue("dokt.orAA@gmail.org.com");

        Set<ConstraintViolation<ContactDTO>> constraintViolation1 = validator.validate(contactDTO1);
        Set<ConstraintViolation<ContactDTO>> constraintViolation2 = validator.validate(contactDTO2);
        Set<ConstraintViolation<ContactDTO>> constraintViolation3 = validator.validate(contactDTO3);

        Assert.assertEquals(0, constraintViolation1.size());
        Assert.assertEquals(0, constraintViolation2.size());
        Assert.assertEquals(0, constraintViolation3.size());
    }

    @Test
    public void secondTest() {
        ContactDTO contactDTO1 = new ContactDTO();
        ContactDTO contactDTO2 = new ContactDTO();
        ContactDTO contactDTO3 = new ContactDTO();

        contactDTO1.setContactValue("doktor94");
        contactDTO2.setContactValue("doktor94@gmail");
        contactDTO3.setContactValue("doktor94.com");

        Set<ConstraintViolation<ContactDTO>> constraintViolation1 = validator.validate(contactDTO1);
        Set<ConstraintViolation<ContactDTO>> constraintViolation2 = validator.validate(contactDTO2);
        Set<ConstraintViolation<ContactDTO>> constraintViolation3 = validator.validate(contactDTO3);

        Assert.assertNotEquals(0, constraintViolation1);
        Assert.assertNotEquals(0, constraintViolation2);
        Assert.assertNotEquals(0, constraintViolation3);
    }
}