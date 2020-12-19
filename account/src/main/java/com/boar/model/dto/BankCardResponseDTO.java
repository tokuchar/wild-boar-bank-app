package com.boar.model.dto;

import com.boar.model.CardType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCardResponseDTO {

    private CardType cardType;

    private String cardNumber;
    private String cardVerificationCode;
    private String PIN;

    private LocalDate validThru;
}
