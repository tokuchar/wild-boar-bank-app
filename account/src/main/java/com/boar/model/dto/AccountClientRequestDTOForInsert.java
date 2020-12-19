package com.boar.model.dto;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountClientRequestDTOForInsert {

    private Long accountId;

    @NotNull(message = "Account number cannot be null.")
    @Pattern(regexp = "\\d{7,10}", message = "Account number contains incorrect value.")
    private String accountNumber;

    @NotNull(message = "Customer ID cannot be null.")
    @Pattern(regexp = "\\d{1,25}", message = "Customer ID is incorrect.")
    private String customerId;

    @NotNull(message = "Balance cannot be null.")
    @Pattern(regexp = "([1-9][0-9]*)?(\\d\\.[0-9][0-9])", message = "Balance contains incorrect value.")
    private String balance;

    @NotNull(message = "Interest cannot be null.")
    @Pattern(regexp = "([1-9])?(\\d\\.[0-9][0-9])", message = "Interest contains incorrect value.")
    private String interest;

    private AccountType accountType;
    private Currency currency;

    @Valid
    private Set<BankCardRequestDTOForInsert> bankCard;
}
