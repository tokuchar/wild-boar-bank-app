package com.boar.model.dto;

import com.boar.model.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankCardDTO {
    Long bankCardId;

    CardType cardType;
//TODO write algorithm Luhn
    String cardNumber;
    @Pattern(regexp = "\\d{3}",
            message = "Card verification code contains incorrect value.")
    String cardVerificationCode;
    @Pattern(regexp = "\\d{4}",
            message = "PIN contains incorrect value.")
    String PIN;
    @Future(message = "Valid Thru is incorrect.")
    LocalDate validThru;
}
