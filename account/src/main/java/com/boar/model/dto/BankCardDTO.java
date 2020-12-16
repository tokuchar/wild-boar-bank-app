package com.boar.model.dto;

import com.boar.model.CardType;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class BankCardDTO {
    private Long bankCardId;

    private CardType cardType;
    //TODO write algorithm Luhn
    private String cardNumber;

    @Pattern(regexp = "\\d{3}", message = "Card verification code contains incorrect value.")
    private String cardVerificationCode;

    @NotNull
    @Pattern(regexp = "\\d{4}", message = "PIN contains incorrect value.")
    private String PIN;

    @Future(message = "Valid Thru is incorrect.")
    private LocalDate validThru;
}
