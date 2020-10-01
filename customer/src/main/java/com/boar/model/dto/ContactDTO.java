package com.boar.model.dto;

import com.boar.model.ContactType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    ContactType contactType;
    String contactValue;
}
