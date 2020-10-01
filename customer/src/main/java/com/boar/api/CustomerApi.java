package com.boar.api;

import com.boar.exception.CustomerAlreadyExistException;
import com.boar.model.dto.CustomerDTO;
import com.boar.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Slf4j
public class CustomerApi {
    final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        try {
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } catch (CustomerAlreadyExistException e) {
            log.error("exception: ", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
