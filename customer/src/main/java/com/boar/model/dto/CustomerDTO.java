package com.boar.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    String name;
    String surname;

    LocalDate birthDate;
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
