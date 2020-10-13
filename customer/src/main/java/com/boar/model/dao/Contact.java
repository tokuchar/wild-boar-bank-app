package com.boar.model.dao;

import com.boar.model.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long contactId;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    ContactType contactType;
    String contactValue;
}
