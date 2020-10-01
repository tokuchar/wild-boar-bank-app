package com.boar.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IdentityDocumentDTO {
    String identity;
    LocalDate expirationDate;
}
