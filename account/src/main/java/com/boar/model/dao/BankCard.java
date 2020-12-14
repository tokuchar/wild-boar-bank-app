package com.boar.model.dao;


import com.boar.model.CardType;
import com.boar.service.GeneratorNumbers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

   // @Column(columnDefinition = "#{T(com.boar.service.GeneratorNumbers).pinGenerator()}")
    private String PIN= GeneratorNumbers.pinGenerator();

    private LocalDate validThru;
}
