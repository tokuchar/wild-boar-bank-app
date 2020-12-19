package com.boar.repository;

import com.boar.model.dao.AccountClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountClient, Long> {

    Optional<AccountClient> findAccountClientByCustomerId(String customerId);
}