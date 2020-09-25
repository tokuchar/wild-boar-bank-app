package com.boar.model.dao;

import com.boar.model.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    AddressType addressType;
    String city;
    String street;
    String houseNumber;
    String zipCode;
}
