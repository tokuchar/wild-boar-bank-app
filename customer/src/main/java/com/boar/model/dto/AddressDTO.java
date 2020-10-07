package com.boar.model.dto;

import com.boar.model.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    AddressType addressType;

    @Pattern(regexp = "[a-zA-Z]+(?:[ '-][a-zA-Z]+)*")
    String city;

    //TODO does not work for example "plac. Bema"
    @Pattern(regexp = "[a-zA-Z]+(?:[ ][a-zA-Z]+)*")
    String street;

    @Pattern(regexp = "\\d+(?:[/]\\d+)*[a-zA-Z]*")
    String houseNumber;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    String zipCode;
}
