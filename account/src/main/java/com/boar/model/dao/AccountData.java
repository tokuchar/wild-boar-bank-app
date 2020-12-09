package com.boar.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.event.spi.PreUpdateEvent;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_data")
public class AccountData implements Serializable {

    @Id
    @Column(name = "account_id")
    private Long accountClientId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "account_id")
    private AccountClient accountClient;

    private String accountNumber;
    private String accountTyp;
    private String currency;
    private String balance;
    private String interest;

}
