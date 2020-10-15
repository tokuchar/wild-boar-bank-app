package com.boar.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO extends RepresentationModel<CustomerDTO> {

    @Pattern(regexp = "\\p{Lu}\\p{Ll}+", message = "Wrong name.")
    String name;

    @Pattern(regexp = "\\p{Lu}\\p{Ll}+(?:[ '-]\\p{Lu}\\p{Ll}+)*", message = "Wrong surname.")
    String surname;

    @Past(message = "Wrong birth date.")
    LocalDate birthDate;

    @PESEL(message = "PESEL is incorrect.")
    @Pattern(regexp = "\\d{11}", message = "PESEL contains incorrect number of characters or \n" + "characters that are not allowed")
    String identityNumber;

    IdentityDocumentDTO identityDocument;

    Set<AddressDTO> addresses;
    Set<ContactDTO> contacts;

    public CustomerDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getIdentityNumber())
                .toUri().toString(), "self"));
    }
}
