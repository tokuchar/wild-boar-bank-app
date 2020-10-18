package com.boar.model.dto;

import com.boar.model.ContactType;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ContactDTO {
    ContactType contactType;

    @Email(message = "Email is incorrect.")
    String contactValue;
}
