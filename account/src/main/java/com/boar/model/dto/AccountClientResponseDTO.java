package com.boar.model.dto;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountClientResponseDTO extends RepresentationModel<AccountClientResponseDTO> {

    private Long accountId;

    private String customerId;
    private String accountNumber;
    private String balance;
    private String interest;

    private LocalDate dateCreated;

    private AccountType accountType;
    private Currency currency;

    private Set<BankCardResponseDTO> bankCard;

    public AccountClientResponseDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getAccountId())
                .toUri().toString(), "self"));
    }
}
