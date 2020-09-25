package com.boar.model.dao;

import com.boar.model.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contact {
    ContactType contactType;
    String contactValue;
}
