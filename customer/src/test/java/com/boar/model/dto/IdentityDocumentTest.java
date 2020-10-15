package com.boar.model.dto;

import com.boar.CheckDataTest;
import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class IdentityDocumentTest extends ValidatorTest implements CheckDataTest {

    @Test
    @Override
    public void checkValidDataTest() {
        IdentityDocumentDTO identityDocumentDTO1 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(2030, 12, 12))
                .build();

        IdentityDocumentDTO identityDocumentDTO2 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(2022, 1, 1))
                .build();

        IdentityDocumentDTO identityDocumentDTO3 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(2020, 10, 30))
                .build();

        compareExpectedToActualValidateErrors(0, identityDocumentDTO1);
        compareExpectedToActualValidateErrors(0, identityDocumentDTO2);
        compareExpectedToActualValidateErrors(0, identityDocumentDTO3);
    }

    @Test
    @Override
    public void checkForInvalidDataTest() {
        IdentityDocumentDTO identityDocumentDTO1 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(2000, 12, 12))
                .build();

        IdentityDocumentDTO identityDocumentDTO2 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(1999, 1, 1))
                .build();

        IdentityDocumentDTO identityDocumentDTO3 = IdentityDocumentDTO.builder()
                .expirationDate(LocalDate.of(2020, 5, 30))
                .build();

        compareExpectedToActualValidateErrors(1, identityDocumentDTO1);
        compareExpectedToActualValidateErrors(1, identityDocumentDTO2);
        compareExpectedToActualValidateErrors(1, identityDocumentDTO3);
    }
}