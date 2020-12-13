package com.boar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountClientDTO extends RepresentationModel<AccountClientDTO> {

    private Long accountId;
    private String customerId;

    private LocalDate dateCreated;

    private String accountNumber;
    private String accountType;
    private String currency;
    private String balance;
    private String interest;

    private Set<BankCardDTO> bankCard;

    public AccountClientDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getAccountId())
                .toUri().toString(), "self"));
    }
}
