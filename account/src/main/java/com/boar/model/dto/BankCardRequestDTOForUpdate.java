package com.boar.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCardRequestDTOForUpdate {

    @NotNull(message = "PIN cannot be null.")
    @Pattern(regexp = "\\d{4}", message = "PIN contains incorrect value.")
    private String PIN;
}
