package com.boar.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IdentityDocumentDTO {
    String identity;

    @Future(message = "Expiration date is incorrect.")
    LocalDate expirationDate;
}