package com.boar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountClientRequestDTOForUpdate {

    @NotNull(message = "Balance cannot be null.")
    @Pattern(regexp = "([1-9][0-9]*)?(\\d\\.[0-9][0-9])", message = "Balance contains incorrect value.")
    private String balance;
}
