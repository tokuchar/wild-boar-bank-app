package com.boar.service;

import com.boar.exception.BankCardNotFoundException;
import com.boar.model.dao.AccountClient;
import com.boar.model.dao.BankCard;
import com.boar.model.dto.AccountClientRequestDTOForInsert;
import com.boar.model.dto.AccountClientResponseDTO;
import com.boar.model.dto.BankCardResponseDTO;
import com.boar.repository.AccountRepo;
import com.boar.repository.BankCardRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;

@Slf4j
@Service
@Builder
public class AccountService {
    final AccountRepo accountRepo;
    final BankCardRepo bankCardRepo;
    final ModelMapper modelMapper;
    final ObjectMapper objectMapper;

    public AccountService(AccountRepo accountRepo, BankCardRepo bankCardRepo, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.accountRepo = accountRepo;
        this.bankCardRepo = bankCardRepo;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public AccountClientResponseDTO createAccount(AccountClientRequestDTOForInsert accountClientRequestDTOForInsert) throws AccountNotFoundException {
        checkIfAccountIsExist(String.valueOf(accountClientRequestDTOForInsert.getAccountId()));

        AccountClient accountClient = modelMapper.map(accountClientRequestDTOForInsert, AccountClient.class);
        accountClient.setDateCreated(LocalDate.now());
        createBankCard(accountClient);

        return modelMapper.map(accountRepo.save(accountClient), AccountClientResponseDTO.class);
    }

    public void createBankCard(AccountClient accountClient) {
        String pin = GeneratorNumbers.pinGenerator();
        String cvc = GeneratorNumbers.cvcGenerator();
        String cardNumber;
        LocalDate validThru = LocalDate.now().plusYears(2);

        for (BankCard bankCard : accountClient.getBankCard()) {
            do
                cardNumber = GeneratorNumbers.cardNumberGenerator();
            while (checkIfBankCardExist(cardNumber));

            bankCard.setCardNumber(cardNumber);
            bankCard.setPIN(pin);
            bankCard.setCardVerificationCode(cvc);
            bankCard.setValidThru(validThru);
        }
    }

    private boolean checkIfBankCardExist(String cardNumber) {
        return bankCardRepo.findBankCardByCardNumber(cardNumber).isPresent();
    }

    public AccountClientResponseDTO getAccount(Long accountId) throws AccountNotFoundException {
        AccountClient account = accountRepo.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(String.format("account about ID: %s not found", accountId)));
        return modelMapper.map(account, AccountClientResponseDTO.class);
    }

    public AccountClientResponseDTO updateAccount(Long accountId, AccountClientRequestDTOForInsert accountClientRequestDTOForInsert) throws AccountNotFoundException {
        return accountRepo.findById(accountId).map(account -> {
            AccountClient updateAccount = modelMapper.map(accountClientRequestDTOForInsert, AccountClient.class);
            updateAccount.setAccountId((account.getAccountId()));
            accountRepo.save(updateAccount);
            return modelMapper.map(updateAccount, AccountClientResponseDTO.class);
        })
                .orElseThrow(() -> new AccountNotFoundException(String.format("account about ID: %s not found", accountId)));
    }

    public AccountClientResponseDTO applyPatchToAccount(JsonPatch patch, Long accountId) throws AccountNotFoundException {
        AccountClient account = accountRepo.findById(accountId)
                .map(a -> {
                    try {
                        return applyPatchToAccount(patch, a);
                    } catch (JsonPatchException | JsonProcessingException e) {
                        log.error("exception: ", e);
                    }
                    return a;
                })
                .orElseThrow(() -> new AccountNotFoundException(String.format("account about ID: %s not found", accountId)));
        return modelMapper.map(account, AccountClientResponseDTO.class);
    }

    private AccountClient applyPatchToAccount(JsonPatch patch, AccountClient targetAccount) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetAccount, JsonNode.class));
        return objectMapper.treeToValue(patched, AccountClient.class);
    }

    public BankCardResponseDTO applyPatchToBankCard(JsonPatch patch, Long bankCardId) throws BankCardNotFoundException {
        BankCard bankCard = bankCardRepo.findById(bankCardId)
                .map(bc -> {
                    try {
                        return applyPatchToBankCard(patch, bc);
                    } catch (JsonPatchException | JsonProcessingException e) {
                        log.error("exception: ", e);
                    }
                    return bc;
                })
                .orElseThrow(() -> new BankCardNotFoundException(String.format("account about ID: %s not found", bankCardId)));
        return modelMapper.map(bankCard, BankCardResponseDTO.class);
    }

    private BankCard applyPatchToBankCard(JsonPatch patch, BankCard targetBankCard) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetBankCard, JsonNode.class));
        return objectMapper.treeToValue(patched, BankCard.class);
    }

    private void checkIfAccountIsExist(String accountId) throws AccountNotFoundException {
        if (accountRepo.findAccountClientByCustomerId(accountId).isPresent()) {
            throw new AccountNotFoundException(
                    String.format("customer about ID: %s already exists", accountId));
        }
    }
}
