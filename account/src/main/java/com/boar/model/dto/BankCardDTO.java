package com.boar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankCardDTO {
    Long bankCardId;

    String type;
    String cardNumber;
    String cardVerificationCode;
    String PIN;
    LocalDate validThru;
}
