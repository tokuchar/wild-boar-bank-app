package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @Pattern(regexp = "[a-zA-Z]+")
    @NotBlank(message = "Please enter name.")
    String name;

    @Pattern(regexp = "[a-zA-Z]+")
    @NotBlank(message = "Please enter surname.")
    String surname;

    @Past(message = "Birth date must be in the past.")
    @NotEmpty(message = "Please enter birth date.")
    //500 http
            LocalDate birthDate;

    @Column(unique = true)
    @PESEL
    String identityNumber;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    IdentityDocument identityDocument;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    Set<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    Set<Contact> contacts;
}
