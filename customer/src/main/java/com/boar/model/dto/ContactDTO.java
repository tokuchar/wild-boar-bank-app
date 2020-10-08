package com.boar.model.dto;

import com.boar.model.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
public class ContactDTO {
    ContactType contactType;

    @Email(message = "Email is incorrect.")
    String contactValue;
}
