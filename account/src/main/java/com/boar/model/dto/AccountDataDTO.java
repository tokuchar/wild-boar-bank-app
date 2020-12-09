package com.boar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDataDTO {

    Long accountId;

    String accountNumber;
    String accountTyp;
    String currency;
    String balance;
    String interest;
}
