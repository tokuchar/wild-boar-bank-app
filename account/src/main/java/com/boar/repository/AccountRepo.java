package com.boar.repository;

import com.boar.model.dao.AccountClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountClient, Long>, CrudRepository<AccountClient, Long> {
    @Override
    <S extends AccountClient> S save(S s);

    @Override
    Optional<AccountClient> findById(Long aLong);

    Optional<AccountClient> findAccountClientByCustomerId(String customerId);

}