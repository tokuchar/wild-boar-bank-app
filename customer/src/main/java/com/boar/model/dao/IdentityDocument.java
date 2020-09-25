package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IdentityDocument {
    String identity;
    LocalDate expirationDate;
}
