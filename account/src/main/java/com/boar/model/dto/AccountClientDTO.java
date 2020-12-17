package com.boar.model.dto;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
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

    private Long accountId;

    @NotNull(message = "Customer ID cannot be null.")
    @Pattern(regexp = "\\d{1,25}", message = "Customer ID is incorrect.")
    private String customerId;

    @NotNull(message = "Date created cannot be null.")
    private LocalDate dateCreated;

    //TODO generated and simply request
    @NotNull(message = "Account number cannot be null.")
    @Pattern(regexp = "\\d{7,10}", message = "Account number contains incorrect value.")
    private String accountNumber;

    @NotNull(message = "Balance cannot be null.")
    @Pattern(regexp = "([1-9][0-9]*)?(\\d\\.[0-9][0-9])", message = "Balance contains incorrect value.")
    private String balance;

    @NotNull(message = "Interest cannot be null.")
    @Pattern(regexp = "([1-9])?(\\d\\.[0-9][0-9])", message = "Interest contains incorrect value.")
    private String interest;

    private AccountType accountType;
    private Currency currency;

    @Valid
    private Set<BankCardDTO> bankCard;

    public AccountClientDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getAccountId())
                .toUri().toString(), "self"));
    }
}
