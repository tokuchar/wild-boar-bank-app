package com.boar.repository;

import com.boar.model.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Override
    <S extends Customer> S save(S s);
}

