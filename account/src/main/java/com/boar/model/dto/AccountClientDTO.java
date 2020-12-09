package com.boar.model.dto;

import com.boar.model.dao.AccountData;
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

    String customerId;

    LocalDate dateCreated;
    AccountDataDTO accountData;

    Set<BankCardDTO> bankCard;



    public AccountClientDTO addSelfLink() {
        return super.add(Link.of(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(this.getCustomerId())
                .toUri().toString(), "self"));
    }
}
