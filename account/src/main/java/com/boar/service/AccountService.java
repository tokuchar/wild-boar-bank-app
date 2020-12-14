package com.boar.service;

import com.boar.exception.AccountAlreadyExistException;
import com.boar.exception.AccountClientNotFoundException;
import com.boar.model.dao.AccountClient;
import com.boar.model.dto.AccountClientDTO;
import com.boar.repository.AccountRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;

@Slf4j
@Service
public class AccountService {
    final AccountRepo accountRepo;
    final ModelMapper modelMapper;
    final ObjectMapper objectMapper;


    public AccountService(AccountRepo accountRepo, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.accountRepo = accountRepo;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public AccountClientDTO createAccount(AccountClientDTO accountClientDTO) throws AccountAlreadyExistException {
        checkIfAccountIsExist(accountClientDTO.getCustomerId());

        AccountClient accountClient = modelMapper.map(accountClientDTO, AccountClient.class);
        return modelMapper.map(accountRepo.save(accountClient), AccountClientDTO.class);
    }

    public AccountClientDTO getAccount(Long accountId) throws AccountClientNotFoundException {
        AccountClient account = accountRepo.findById(accountId)
                .orElseThrow(() -> new AccountClientNotFoundException(String.format("account about ID: %s not found", accountId)));
        return modelMapper.map(account, AccountClientDTO.class);
    }


    public AccountClientDTO updateAccount(Long accountId, AccountClientDTO accountClientDTO) throws AccountClientNotFoundException{
        return accountRepo.findById(accountId).map(account -> {
            AccountClient updateAccount = modelMapper.map(accountClientDTO, AccountClient.class);
            updateAccount.setAccountId((account.getAccountId()));
            accountRepo.save(updateAccount);
            return modelMapper.map(updateAccount, AccountClientDTO.class);
        })
                .orElseThrow(() -> new AccountClientNotFoundException(String.format("account about ID: %s not found", accountId)));
    }

    public AccountClientDTO applyPatchToAccount(JsonPatch patch, Long accountId) throws AccountClientNotFoundException {
        AccountClient account = accountRepo.findById(accountId)
                .map(a -> {
                    try {
                        return applyPatchToAccount(patch, a);
                    } catch (JsonPatchException | JsonProcessingException e) {
                        log.error("exception: ", e);
                    }
                    return a;
                })
                .orElseThrow(() -> new AccountClientNotFoundException(String.format("account about ID: %s not found", accountId)));
        return modelMapper.map(account, AccountClientDTO.class);
    }

    private AccountClient applyPatchToAccount(JsonPatch patch, AccountClient targetAccount) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetAccount, JsonNode.class));
        return objectMapper.treeToValue(patched, AccountClient.class);
    }

    private void checkIfAccountIsExist(String customerId) throws AccountAlreadyExistException {
        if (accountRepo.findAccountClientByCustomerId(customerId).isPresent()) {
            throw new AccountAlreadyExistException(
                    String.format("account %s already exists", customerId));
        }
    }
}
