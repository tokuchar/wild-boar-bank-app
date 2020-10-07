package com.boar.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IdentityDocumentDTO {
    //TODO method is already, only put this
    @Pattern(regexp = "[A-Z]{3}[0-9]{6}")
    String identity;

    @Future
    LocalDate expirationDate;
}