package com.boar.model.dao;

import com.boar.model.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    AddressType addressType;

    String city;
    String street;
    String houseNumber;
    String zipCode;
}
