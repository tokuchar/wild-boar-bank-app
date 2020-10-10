package com.boar.service;

import com.boar.exception.CustomerAlreadyExistException;
import com.boar.exception.CustomerNotFoundException;
import com.boar.exception.IdentityDocumentIsWrong;
import com.boar.model.dto.CustomerDTO;
import com.boar.repository.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.dialect.CUBRIDDialect;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    CustomerService customerService;
    CustomerRepo customerRepo;
    ModelMapper modelMapper;
    ObjectMapper objectMapper;
    ValidatorService validatorService;


}