package com.boar.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO extends RepresentationModel<CustomerDTO> {

    @Pattern(regexp = "[a-zA-Z]+", message = "Please enter name.")
    String name;

    @Pattern(regexp = "[a-zA-Z]+", message = "Please enter surname.")
    String surname;

    @Past(message = "Birth date must be in the past.")
    LocalDate birthDate;

    @PESEL
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
