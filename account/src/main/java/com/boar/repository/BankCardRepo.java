package com.boar.repository;

import com.boar.model.dao.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankCardRepo extends JpaRepository<BankCard, Long> {

    Optional<BankCard> findBankCardByCardNumber(String cardNumber);
}
