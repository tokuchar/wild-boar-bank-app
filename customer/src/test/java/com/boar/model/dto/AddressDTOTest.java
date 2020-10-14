package com.boar.model.dto;

import com.boar.ValidatorTest;
import org.junit.jupiter.api.Test;

class AddressDTOTest extends ValidatorTest {

    @Test
    public void checksValidDataTest() {
        AddressDTO addressDTO1 = AddressDTO.builder()
                .city("Wrocław")
                .zipCode("50-001")
                .street("Plac Bema")
                .houseNumber("32a")
                .build();

        AddressDTO addressDTO2 = AddressDTO.builder()
                .city("Nowy Świat")
                .zipCode("66-131")
                .street("Ulica Kościuszki")
                .houseNumber("5")
                .build();

        AddressDTO addressDTO3 = AddressDTO.builder()
                .city("Zielona Góra")
                .zipCode("65-999")
                .street("Ulica Niepodległości")
                .houseNumber("32/33")
                .build();

        compareExpectedToActualValidateErrors(0, addressDTO1);
        compareExpectedToActualValidateErrors(0, addressDTO2);
        compareExpectedToActualValidateErrors(0, addressDTO3);
    }

    @Test
    public void checksForInvalidDataTest() {
        AddressDTO addressDTO1 = AddressDTO.builder()
                .city("Wroc1ław")
                .zipCode("50001")
                .street("PlacBema")
                .houseNumber("a32")
                .build();

        AddressDTO addressDTO2 = AddressDTO.builder()
                .city("NowyŚwiat")
                .zipCode("66/131")
                .street("123")
                .houseNumber("Ulica Kościuszki")
                .build();

        AddressDTO addressDTO3 = AddressDTO.builder()
                .city("436/;")
                .zipCode("aa-aaa")
                .street("14445656")
                .houseNumber("Bema 24")
                .build();

        compareExpectedToActualValidateErrors(4, addressDTO1);
        compareExpectedToActualValidateErrors(4, addressDTO2);
        compareExpectedToActualValidateErrors(4, addressDTO3);
    }
}
