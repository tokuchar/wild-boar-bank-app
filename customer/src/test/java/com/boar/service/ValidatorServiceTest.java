package com.boar.service;

import com.boar.CheckDataTest;
import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

class ValidatorServiceTest extends ValidatorTest implements CheckDataTest {

    @Test
    @Override
    public void checkValidDataTest() {
        validateWithUsesMethodCheckIfIdentityIsCorrect("DYQ723005");
        validateWithUsesMethodCheckIfIdentityIsCorrect("ART831293");
        validateWithUsesMethodCheckIfIdentityIsCorrect("MER255106");
    }

    @Test
    @Override
    public void checkForInvalidDataTest() {
        invalidateWithUsesMethodCheckIfIdentityIsCorrect("MER2551061010");
        invalidateWithUsesMethodCheckIfIdentityIsCorrect("ARTGBC293");
        invalidateWithUsesMethodCheckIfIdentityIsCorrect("123355106");
        invalidateWithUsesMethodCheckIfIdentityIsCorrect("MER155106");
        invalidateWithUsesMethodCheckIfIdentityIsCorrect(" ");
        invalidateWithUsesMethodCheckIfIdentityIsCorrect(";;;//>{:{");
    }
}

