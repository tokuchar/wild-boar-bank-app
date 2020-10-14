package com.boar.model.dto;

import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CustomerDTOTest extends ValidatorTest {

    @Test
    public void checkValidDataTest() {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .identityNumber("80010426546")
                .name("Łukasz")
                .surname("Kowalski")
                .birthDate(LocalDate.of(1999, 10, 10))
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .identityNumber("80010426546")
                .name("Joanna")
                .surname("Kołeczewska-Ruchała")
                .birthDate(LocalDate.of(1980, 11, 2))
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .identityNumber("80010426546")
                .name("Kajetan")
                .surname("Dąbrowska")
                .birthDate(LocalDate.of(2000, 5, 30))
                .build();

        compareExpectedToActualValidateErrors(0, customerDTO1);
        compareExpectedToActualValidateErrors(0, customerDTO2);
        compareExpectedToActualValidateErrors(0, customerDTO3);
    }

    @Test
    public void checkForInvalidDataTest() {// jeden error jest
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .identityNumber("80010336546") //zastapienie literami nie wywala bledu
                .name("Łukasz1")
                .surname("Kowalski21")
                .birthDate(LocalDate.of(2021, 10, 10))
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder() //jeden error jest
               // .identityNumber("80010026546")
                .name("123")
                .surname("Kołeczewska.Ruchała")
               .birthDate(LocalDate.of(2020, 12, 2))
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .identityNumber("8001042654")
                .name("Kaje t1an")
                .surname("1235")
                .birthDate(LocalDate.of(2050, 5, 30))
                .build();

        compareExpectedToActualValidateErrors(4, customerDTO1);
        compareExpectedToActualValidateErrors(3, customerDTO2);
        compareExpectedToActualValidateErrors(4, customerDTO3);
    }
}