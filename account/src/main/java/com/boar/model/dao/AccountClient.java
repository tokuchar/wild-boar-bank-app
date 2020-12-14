package com.boar.model.dao;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_client")
public class AccountClient {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String customerId;

    @Column(columnDefinition = "#{T(java.time.LocalDateTime).now()}")
    private LocalDate dateCreated;

    private String accountNumber;
    private String balance;
    private String interest;

    private AccountType accountType;
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Set<BankCard> bankCard;
}
