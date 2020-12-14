package com.boar.model.dto;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountClientDTO extends RepresentationModel<AccountClientDTO> {

    Long accountId;

    @Pattern(regexp = "\\d{1,25}", message = "Customer ID is incorrect.")
    String customerId;

    LocalDate dateCreated;

    @Pattern(regexp = "\\d{7,10}", message = "Account number contains incorrect value.")
    String accountNumber;

    @NotNull
    @Pattern(regexp = "([1-9][0-9]*)?(\\d\\.[0-9][0-9])", message = "Balance contains incorrect value.")
    String balance;

    @Pattern(regexp = "([1-9][0-9]{2})?(\\d\\.[0-9][0-9])", message = "Interest contains incorrect value.")
    String interest;

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
