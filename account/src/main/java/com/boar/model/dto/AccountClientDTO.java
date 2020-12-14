package com.boar.model.dto;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountClientDTO extends RepresentationModel<AccountClientDTO> {

    private Long accountId;
    @Pattern(regexp = "\\d{1,25}",
            message = "Customer ID is incorrect.")
    private String customerId;

    @Pattern(regexp = "\\d{7,10}",
            message = "Account number contains incorrect value.")
    private String accountNumber;

    @Pattern(regexp = "([1-9][0-9]*)?(\\d\\.[0-9][0-9])",
            message = "Balance contains incorrect value.")
    private String balance;

    @Pattern(regexp = "([1-9][0-9]{2})?(\\d\\.[0-9][0-9])",
            message = "Interest contains incorrect value.")
    private String interest;

    private AccountType accountType;
    private Currency currency;

    private Set<BankCardDTO> bankCard;

    public AccountClientDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getAccountId())
                .toUri().toString(), "self"));
    }
}
