package com.boar.model.dto;

import com.boar.CheckDataTest;
import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

class ContactDTOTest extends ValidatorTest implements CheckDataTest {

    @Test
    @Override
    public void checkValidDataTest() {
        ContactDTO contactDTO1 = ContactDTO.builder()
                .contactValue("doktor@gmail.com")
                .build();

        ContactDTO contactDTO2 = ContactDTO.builder()
                .contactValue("doktor@wp")
                .build();

        ContactDTO contactDTO3 = ContactDTO.builder()
                .contactValue("doktor@check.end")
                .build();

        compareExpectedToActualValidateErrors(0, contactDTO1);
        compareExpectedToActualValidateErrors(0, contactDTO2);
        compareExpectedToActualValidateErrors(0, contactDTO3);
    }

    @Test
    @Override
    public void checkForInvalidDataTest() {
        ContactDTO contactDTO1 = ContactDTO.builder()
                .contactValue("doktor. gmail.com")
                .build();

        ContactDTO contactDTO2 = ContactDTO.builder()
                .contactValue("doktor94@gm ail")
                .build();

        ContactDTO contactDTO3 = ContactDTO.builder()
                .contactValue("doktor@check@end")
                .build();

        compareExpectedToActualValidateErrors(1, contactDTO1);
        compareExpectedToActualValidateErrors(1, contactDTO2);
        compareExpectedToActualValidateErrors(1, contactDTO3);
    }
}