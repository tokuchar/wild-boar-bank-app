package com.boar.model.dto;

import lombok.*;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityDocumentDTO {
    String identity;

    @Future(message = "Expiration date is incorrect.")
    LocalDate expirationDate;
}