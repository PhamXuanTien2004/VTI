package vti.dtn.account_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vti.dtn.account_service.entity.AccountEntity;
import vti.dtn.account_service.model.Account;
import vti.dtn.account_service.service.AccountService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getListAccounts() {
        List<AccountEntity> accountEntities = accountService.getListAccounts();
        return accountEntities.stream()
                .map(accountEntity -> new Account(
                        accountEntity.getId(),
                        accountEntity.getUsername(),
                        accountEntity.getFirstName(),
                        accountEntity.getLastName()))
                .toList();
    }
}
