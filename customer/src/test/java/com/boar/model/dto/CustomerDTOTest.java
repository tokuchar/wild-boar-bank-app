package com.boar.model.dto;

import com.boar.CheckDataTest;
import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CustomerDTOTest extends ValidatorTest implements CheckDataTest {

    @Test
    @Override
    public void checkValidDataTest() {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .identityNumber("79010322693")
                .name("Łukasz")
                .surname("Kowalski")
                .birthDate(LocalDate.of(1999, 10, 10))
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .identityNumber("89103117545")
                .name("Joanna")
                .surname("Kołeczewska-Ruchała")
                .birthDate(LocalDate.of(1980, 11, 2))
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .identityNumber("59081584558")
                .name("Kajetan")
                .surname("Dąbrowska")
                .birthDate(LocalDate.of(2000, 5, 30))
                .build();

        compareExpectedToActualValidateErrors(0, customerDTO1);
        compareExpectedToActualValidateErrors(0, customerDTO2);
        compareExpectedToActualValidateErrors(0, customerDTO3);
    }

    @Test
    @Override
    public void checkForInvalidDataTest() {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .identityNumber("a9081584559")
                .name("łukasz")
                .surname("kowalski")
                .birthDate(LocalDate.of(2020, 10, 30))
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder() //jeden error jest
                .identityNumber("89103117546")
                .name("123")
                .surname("Kołeczewska.Ruchała")
                .birthDate(LocalDate.of(2020, 12, 2))
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .identityNumber("Sb cd")
                .name("Kaje t1an")
                .surname("1235")
                .birthDate(LocalDate.of(2050, 5, 30))
                .build();

        compareExpectedToActualValidateErrors(5, customerDTO1);
        compareExpectedToActualValidateErrors(4, customerDTO2);
        compareExpectedToActualValidateErrors(5, customerDTO3);
    }
}