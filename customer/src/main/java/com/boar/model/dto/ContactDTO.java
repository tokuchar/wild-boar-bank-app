package com.boar.model.dto;

import com.boar.model.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDTO {
    ContactType contactType;
    String contactValue;
}
