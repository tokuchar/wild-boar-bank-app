package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class IdentityDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long documentId;

    @Column(unique = true)
    String identity;
    LocalDate expirationDate;
}
