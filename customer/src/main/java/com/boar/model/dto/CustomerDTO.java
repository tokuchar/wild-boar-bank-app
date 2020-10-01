package com.boar.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class CustomerDTO {
    String name;
    String surname;

    LocalDate birthDate;
    String identityNumber;
    IdentityDocumentDTO identityDocument;
    Set<AddressDTO> addresses;
    Set<ContactDTO> contacts;
}
