package com.boar.model.dto;

import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

class ContactDTOTest extends ValidatorTest {

    @Test
    public void checksValidDataTest() {
        ContactDTO contactDTO1 = ContactDTO.builder()
                .contactValue("doktor@gmail.com")
                .build();

        ContactDTO contactDTO2 = ContactDTO.builder()
                .contactValue("doktor@wp.pl")
                .build();

        ContactDTO contactDTO3 = ContactDTO.builder()
                .contactValue("doktor@check.end")
                .build();

        compareExpectedToActualValidateErrors(0, contactDTO1);
        compareExpectedToActualValidateErrors(0, contactDTO2);
        compareExpectedToActualValidateErrors(0, contactDTO3);
    }

    @Test
    public void checksForInvalidDataTest() {
        ContactDTO contactDTO1 = ContactDTO.builder()
                .contactValue("doktor. gmail.com")
                .build();
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setContactValue("doktor94@gmail");

        ContactDTO contactDTO2 = ContactDTO.builder()
                .contactValue("doktor94@gmail") //TODO regexp for validate email
                .build();

        ContactDTO contactDTO3 = ContactDTO.builder()
                .contactValue("doktor@check@end")
                .build();

        compareExpectedToActualValidateErrors(1, contactDTO1);
        compareExpectedToActualValidateErrors(1, contactDTO);
        compareExpectedToActualValidateErrors(1, contactDTO2);
        compareExpectedToActualValidateErrors(1, contactDTO3);
    }
}