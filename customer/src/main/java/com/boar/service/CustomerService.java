package com.boar.service;


import com.boar.exception.CustomerAlreadyExistException;
import com.boar.exception.CustomerNotFoundException;
import com.boar.model.dao.Customer;
import com.boar.model.dto.CustomerDTO;
import com.boar.repository.CustomerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Slf4j
@Service
public class CustomerService {
    final CustomerRepo customerRepo;
    final ModelMapper modelMapper;
    final ObjectMapper objectMapper;
final ValidatorService validatorService;

    public CustomerService(CustomerRepo customerRepo, ModelMapper modelMapper, ObjectMapper objectMapper, ValidatorService validatorService) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.validatorService=validatorService;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExistException, ConstraintViolationException {
        checkIfClientExists(customerDTO.getIdentityNumber());

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return modelMapper.map(customerRepo.save(customer), CustomerDTO.class);
    }

    private void checkIfClientExists(String identityNumber) throws CustomerAlreadyExistException {
        if (customerRepo.findCustomerByIdentityNumber(identityNumber).isPresent()) {
            throw new CustomerAlreadyExistException(
                    String.format("client %s already exists", identityNumber));
        }
    }

    public CustomerDTO applyPatchToCustomer(JsonPatch patch, String identityNumber) throws CustomerNotFoundException {
        Customer customer = customerRepo.findCustomerByIdentityNumber(identityNumber)
                .map(c -> {
                    try {
                        return applyPatchToCustomer(patch, c);
                    } catch (JsonPatchException | JsonProcessingException e) {
                        log.error("exception: ", e);
                    }
                    return c;
                })
                .orElseThrow(() -> new CustomerNotFoundException(String.format("client %s not found", identityNumber)));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        return objectMapper.treeToValue(patched, Customer.class);
    }

    public CustomerDTO getCustomer(String identityNumber) throws CustomerNotFoundException {
        Customer customer = customerRepo.findCustomerByIdentityNumber(identityNumber)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("client %s not found", identityNumber)));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(String identityNumber, CustomerDTO customerDTO) throws CustomerNotFoundException {
        return customerRepo.findCustomerByIdentityNumber(identityNumber)
                .map(customer -> {
                    Customer updatedCustomer = modelMapper.map(customerDTO, Customer.class);
                    updatedCustomer.setCustomerId(customer.getCustomerId());
                    customerRepo.save(updatedCustomer);
                    return modelMapper.map(updatedCustomer, CustomerDTO.class);
                })
                .orElseThrow(() -> new CustomerNotFoundException(String.format("client %s not found", identityNumber)));
    }
}
