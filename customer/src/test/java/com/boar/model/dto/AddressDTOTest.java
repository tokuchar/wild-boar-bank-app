package com.boar.model.dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

class AddressDTOTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void firstTest() {
        AddressDTO addressDTO1 = new AddressDTO();
        AddressDTO addressDTO2 = new AddressDTO();
        AddressDTO addressDTO3 = new AddressDTO();

        addressDTO1.setStreet("Plac Bema");
        addressDTO2.setStreet("Ulica Kościuszki");
        addressDTO3.setStreet("Ulica Niepodległości");

        addressDTO1.setHouseNumber("32a");
        addressDTO2.setHouseNumber("32/33");
        addressDTO3.setHouseNumber("1");

        addressDTO1.setCity("Wrocław");
        addressDTO2.setCity("Nowy Świat");
        addressDTO3.setCity("Zielona Góra");

        addressDTO1.setZipCode("50-001");
        addressDTO2.setZipCode("66-131");
        addressDTO1.setZipCode("65-999");

        Set<ConstraintViolation<AddressDTO>> constraintViolation1 = validator.validate(addressDTO1);
        Set<ConstraintViolation<AddressDTO>> constraintViolation2 = validator.validate(addressDTO2);
        Set<ConstraintViolation<AddressDTO>> constraintViolation3 = validator.validate(addressDTO3);

        Assert.assertEquals(0, constraintViolation1.size());
        Assert.assertEquals(0, constraintViolation2.size());
        Assert.assertEquals(0, constraintViolation3.size());
    }

    @Test
    public void secondTest() {
        AddressDTO addressDTO1 = new AddressDTO();
        AddressDTO addressDTO2 = new AddressDTO();
        AddressDTO addressDTO3 = new AddressDTO();

        addressDTO1.setStreet("Niepod1egłości");
        addressDTO2.setStreet("Niepod egłości");
        addressDTO3.setStreet("12345/");

        addressDTO1.setHouseNumber("Aa");
        addressDTO2.setHouseNumber(";.;");
        addressDTO3.setHouseNumber("12+12");

        addressDTO1.setStreet("WWrocław");
        addressDTO2.setStreet("WWroc1aw");
        addressDTO3.setStreet("WWroc aw");

        addressDTO1.setZipCode("50001");
        addressDTO2.setZipCode("=-'=-");
        addressDTO3.setZipCode("aa-abc");

        Set<ConstraintViolation<AddressDTO>> constraintViolations1 = validator.validate(addressDTO1);
        Set<ConstraintViolation<AddressDTO>> constraintViolations2 = validator.validate(addressDTO2);
        Set<ConstraintViolation<AddressDTO>> constraintViolations3 = validator.validate(addressDTO3);

        Assert.assertNotEquals(0, constraintViolations1.size());
        Assert.assertNotEquals(0, constraintViolations2.size());
        Assert.assertNotEquals(0, constraintViolations3.size());
    }
}