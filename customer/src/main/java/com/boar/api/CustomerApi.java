package com.boar.api;

import com.boar.model.dao.Customer;
import com.boar.repository.CustomerRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class CustomerApi {
    final CustomerRepo customerRepo;

    public CustomerApi(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return ResponseEntity.ok(customer);
    }
}
