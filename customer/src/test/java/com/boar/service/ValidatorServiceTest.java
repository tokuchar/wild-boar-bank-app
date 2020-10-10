package com.boar.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceTest {

    @Test
    void checkIfIdentityIsCorrect() {
        ValidatorService validatorService=new ValidatorService();
        assertTrue(validatorService.checkIfIdentityIsCorrect("DYQ723005"));
        assertTrue(validatorService.checkIfIdentityIsCorrect("ART831293"));
        assertTrue(validatorService.checkIfIdentityIsCorrect("MER255106"));

        assertFalse(validatorService.checkIfIdentityIsCorrect("MER2551061010"));
        assertFalse(validatorService.checkIfIdentityIsCorrect("ARTGBC293"));
        assertFalse(validatorService.checkIfIdentityIsCorrect("123355106"));
        assertFalse(validatorService.checkIfIdentityIsCorrect("MER155106"));
        assertFalse(validatorService.checkIfIdentityIsCorrect(" "));
        assertFalse(validatorService.checkIfIdentityIsCorrect(";;;//>{:{"));
    }
}