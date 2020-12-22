package com.boar.repository;

import com.boar.model.dao.AccountClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountClient, Long>, CrudRepository<AccountClient,Long> {

    Optional<AccountClient> findAccountClientByCustomerId(String customerId);
//    @Query("SELECT account_id FROM account_client WHERE customer_id = ?1")
    List<AccountClient> findAllAccountClientByCustomerId(String customerId);

}