package com.boar.api;

import com.boar.exception.CustomerAlreadyExistException;
import com.boar.exception.CustomerNotFoundException;
import com.boar.exception.IdentityDocumentException;
import com.boar.model.dto.CustomerDTO;
import com.boar.service.CustomerService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Slf4j
@RequestMapping("/customers")
public class CustomerApi {
    final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) throws CustomerAlreadyExistException, IdentityDocumentException {
        return ResponseEntity.ok(customerService.createCustomer(customer)
                .addSelfLink());
    }

    @PatchMapping(path = "/{identityNumber}", consumes = "application/json-patch+json")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String identityNumber,
                                                      @RequestBody JsonPatch patch) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.applyPatchToCustomer(patch, identityNumber));
    }

    @PutMapping(path = "/{identityNumber}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String identityNumber,
                                                      @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.updateCustomer(identityNumber, customerDTO));
    }

    @GetMapping(path = "/{identityNumber}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String identityNumber) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.getCustomer(identityNumber)
                .addSelfLink());
    }
}
