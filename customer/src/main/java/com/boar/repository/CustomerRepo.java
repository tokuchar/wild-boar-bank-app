package com.boar.repository;

import com.boar.model.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Override
    <S extends Customer> S save(S s);

    @Query("select c from Customer c where c.identityNumber = ?1")
    Optional<Customer> findCustomerByIdentityNumber(String identityNumber);
}

