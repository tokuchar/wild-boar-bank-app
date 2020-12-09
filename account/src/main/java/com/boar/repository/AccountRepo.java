package com.boar.repository;

import com.boar.model.dao.AccountClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountClient, Long> {
    @Override
    <S extends AccountClient> S save(S s);

    @Override
    AccountClient getOne(Long var1);

    Optional<AccountClient> findAccountClientByCustomerId(String customerId);

    Optional<AccountClient> findAccountClientByAccountId(Long accountId);

}