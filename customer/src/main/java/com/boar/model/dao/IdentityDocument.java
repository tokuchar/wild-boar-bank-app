package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class IdentityDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long documentId;

    String identity;
    LocalDate expirationDate;

    @OneToOne(mappedBy = "identityDocument",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    Customer customer;
}
