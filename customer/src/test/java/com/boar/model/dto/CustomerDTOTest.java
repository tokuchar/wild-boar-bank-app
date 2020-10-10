package com.boar.model.dto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

class CustomerDTOTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void firstTest() {
        CustomerDTO customerDTO1 = new CustomerDTO();
        CustomerDTO customerDTO2 = new CustomerDTO();
        CustomerDTO customerDTO3 = new CustomerDTO();

        customerDTO1.setIdentityNumber("80010426546");
        customerDTO2.setIdentityNumber("80010426546");
        customerDTO3.setIdentityNumber("80010426546");

        customerDTO1.setName("Łukasz");
        customerDTO2.setName("Joanna");
        customerDTO3.setName("Kajetan");

        customerDTO1.setSurname("Kowalski");
        customerDTO2.setSurname("Kołeczewska-Ruchała");
        customerDTO3.setSurname("Dąbrowska");

        customerDTO1.setBirthDate(LocalDate.of(1999, 10, 10));
        customerDTO2.setBirthDate(LocalDate.of(1980, 11, 2));
        customerDTO3.setBirthDate(LocalDate.of(2000, 5, 30));

        Set<ConstraintViolation<CustomerDTO>> constraintViolations1 = validator.validate(customerDTO1);
        Set<ConstraintViolation<CustomerDTO>> constraintViolations2 = validator.validate(customerDTO2);
        Set<ConstraintViolation<CustomerDTO>> constraintViolations3 = validator.validate(customerDTO3);

        Assert.assertEquals(0, constraintViolations1.size());
        Assert.assertEquals(0, constraintViolations2.size());
        Assert.assertEquals(0, constraintViolations3.size());
    }

    @Test
    public void secondTest() {
        CustomerDTO customerDTO1 = new CustomerDTO();
        CustomerDTO customerDTO2 = new CustomerDTO();
        CustomerDTO customerDTO3 = new CustomerDTO();

        customerDTO1.setIdentityNumber("800104265461");
        customerDTO2.setIdentityNumber("abCDEGGJAKEN");
        customerDTO3.setIdentityNumber("1123");

        customerDTO1.setName("Łukasz12");
        customerDTO2.setName("ąbćdeg");
        customerDTO3.setName("123");

        customerDTO1.setSurname("Kowalski12");
        customerDTO2.setSurname("123");
        customerDTO3.setSurname("aaaaaAAAAbbb-aa");

        customerDTO1.setBirthDate(LocalDate.of(2030, 10, 10));
        customerDTO2.setBirthDate(LocalDate.of(2024, 12, 30));
        customerDTO3.setBirthDate(LocalDate.of(2020, 12, 1));

        // Validate the object
        Set<ConstraintViolation<CustomerDTO>> constraintViolations1 = validator.validate(customerDTO1);
        Set<ConstraintViolation<CustomerDTO>> constraintViolations2 = validator.validate(customerDTO2);
        Set<ConstraintViolation<CustomerDTO>> constraintViolations3 = validator.validate(customerDTO3);

        // This is the line that will cause your unit test to fail if there are not any violations
        Assert.assertNotEquals(0, constraintViolations1.size());
        Assert.assertNotEquals(0, constraintViolations2.size());
        Assert.assertNotEquals(0, constraintViolations3.size());
    }
}