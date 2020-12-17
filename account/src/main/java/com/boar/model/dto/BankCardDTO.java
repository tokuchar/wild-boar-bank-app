package com.boar.model.dto;

import com.boar.model.CardType;
import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCardDTO {
    private Long bankCardId;

    private CardType cardType;
    //TODO write algorithm Luhn
    @NotNull(message = "Card number cannot be null.")
    private String cardNumber;

    @NotNull(message = "CVC cannot be null.")
    @Pattern(regexp = "\\d{3}", message = "Card verification code contains incorrect value.")
    private String cardVerificationCode;

    @NotNull(message = "PIN cannot be null.")
    @Pattern(regexp = "\\d{4}", message = "PIN contains incorrect value.")
    private String PIN;

    @NotNull(message = "Valid thru cannot be null.")
    @FutureOrPresent(message = "Valid Thru is incorrect.")
    private LocalDate validThru;
}
