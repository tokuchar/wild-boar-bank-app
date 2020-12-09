package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "bank_card")
public class BankCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_card_id")
    private Long bankCardId;

    private String Type;
    private String cardNumber;

    private String cardVerificationCode;
    private String PIN;
    private LocalDate validThru;
}
