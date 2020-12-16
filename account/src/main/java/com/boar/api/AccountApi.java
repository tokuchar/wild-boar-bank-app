package com.boar.api;

import com.boar.model.dto.AccountClientDTO;
import com.boar.service.AccountService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

@EnableSwagger2
@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountApi {
    final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountClientDTO> createAccount(@RequestBody @Valid AccountClientDTO account) throws AccountNotFoundException {
        return ResponseEntity.ok(accountService.createAccount(account)
                .addSelfLink());
    }

    @PutMapping(path = "/{accountId}")
    public ResponseEntity<AccountClientDTO> updateAccount(@PathVariable("accountId") Long accountId,
                                                          @RequestBody AccountClientDTO account) throws AccountNotFoundException {
        return ResponseEntity.ok(accountService.updateAccount(accountId, account).addSelfLink());
    }

    @PatchMapping(value = "/{accountId}", consumes = "application/json-patch+json")
    public ResponseEntity<AccountClientDTO> updatePartAccount(@RequestBody Long accountId, @PathVariable JsonPatch patch) throws AccountNotFoundException {
        return ResponseEntity.ok(accountService.applyPatchToAccount(patch, accountId));
    }

    @GetMapping(path = "/{accountId}")
    public ResponseEntity<AccountClientDTO> getAccount(@PathVariable("accountId") Long accountId) throws AccountNotFoundException {
        return ResponseEntity.ok(accountService.getAccount(accountId)
                .addSelfLink());
    }
}
