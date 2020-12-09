package com.boar.api;

import com.boar.exception.AccountAlreadyExistException;
import com.boar.exception.AccountClientNotFoundException;
import com.boar.model.dto.AccountClientDTO;
import com.boar.service.AccountService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.extern.slf4j.Slf4j;
import org.kie.internal.builder.conf.LanguageLevelOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
    public ResponseEntity<AccountClientDTO> createAccount(@RequestBody AccountClientDTO account) throws AccountAlreadyExistException {
        return ResponseEntity.ok(accountService.createAccount(account)
                .addSelfLink());
    }

    @PutMapping(path = "/{accountId}")
    public ResponseEntity<AccountClientDTO> updateAccount(@PathVariable("accountId") Long accountId,
                                                          @RequestBody AccountClientDTO account) throws AccountClientNotFoundException {
        return ResponseEntity.ok(accountService.updateAccount(accountId, account).addSelfLink());
    }

    @PatchMapping(value = "/{accountId}", consumes = "application/json-patch+json")
    public ResponseEntity<AccountClientDTO> updatePartAccount(@RequestBody Long accountId, @PathVariable JsonPatch patch) throws AccountClientNotFoundException {
        return ResponseEntity.ok(accountService.applyPatchToAccount(patch, accountId));
    }

    @GetMapping(path = "/{accountId}")
    public ResponseEntity<AccountClientDTO> getAccount(@PathVariable("accountId") Long accountId) throws AccountClientNotFoundException {
        return ResponseEntity.ok(accountService.getAccount(accountId)
                .addSelfLink());
    }
}
