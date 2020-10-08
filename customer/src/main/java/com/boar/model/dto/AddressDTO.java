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

    @Pattern(regexp = "\\p{Lu}\\p{Ll}+(?:[ -]\\p{Lu}\\p{Ll}+)*", message = "City is incorrect.")
    String city;

    @Pattern(regexp = "\\p{Lu}\\p{Ll}+(?:[ -]\\p{Lu}\\p{Ll}+)*", message = "Street is incorrect.")
    String street;

    @Pattern(regexp = "\\d+(?:[/]\\d+)*[a-zA-Z]*", message = "House number is incorrect.")
    String houseNumber;

    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Zip code is incorrect")
    String zipCode;
}