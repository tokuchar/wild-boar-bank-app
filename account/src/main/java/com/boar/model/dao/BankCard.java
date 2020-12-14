package com.boar.model.dao;

import com.boar.model.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "bank_card")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_card_id")
    private Long bankCardId;

    @Column(name = "type")
    private CardType cardType;

    private String cardNumber;
    private String cardVerificationCode;
    private String PIN;

    private LocalDate validThru;
}
