package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_client")
public class AccountClient implements Serializable {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String customerId;
    private LocalDate dateCreated;

    @OneToOne(mappedBy = "accountClient",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private AccountData accountData;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Set<BankCard> bankCard;

    public void setAccountData(AccountData accountData) {
        if (accountData == null) {
            if (this.accountData != null) {
                this.accountData.setAccountClient(null);
            }
        } else {
            accountData.setAccountClient(this);
        }
        this.accountData = accountData;
    }
}
