package com.boar.service;

import com.boar.exception.CustomerAlreadyExistException;
import com.boar.model.dao.Customer;
import com.boar.model.dto.CustomerDTO;
import com.boar.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    final CustomerRepo customerRepo;
    final ModelMapper modelMapper;

    public CustomerService(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExistException {
        checkIfClientExists(customerDTO.getIdentityNumber());

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return modelMapper.map(customerRepo.save(customer), CustomerDTO.class);
    }

    private void checkIfClientExists(String identityNumber) throws CustomerAlreadyExistException {
        if (customerRepo.findCustomerByIdentityNumber(identityNumber).isPresent()) {
            throw new CustomerAlreadyExistException(String.format("client %s already exists", identityNumber));
        }
    }
}
