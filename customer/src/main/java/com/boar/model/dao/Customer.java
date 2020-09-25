package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    String name;
    String surname;
    LocalDate birthDate;
    String identityNumber;
    IdentityDocument identityDocument;
    Set<Address> addresses;
    Set<Contact> contacts;
 }
