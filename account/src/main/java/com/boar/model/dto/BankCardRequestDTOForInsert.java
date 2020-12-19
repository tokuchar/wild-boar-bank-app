package com.boar.model.dto;

import com.boar.model.CardType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCardRequestDTOForInsert {
    private Long bankCardId;

    private CardType cardType;
}
