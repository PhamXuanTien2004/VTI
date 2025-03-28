package com.vti.TestingSystem6.controller;

import com.vti.TestingSystem6.dto.AccountDTO;
import com.vti.TestingSystem6.entity.Account;
import com.vti.TestingSystem6.form.AccountFilterForm;
import com.vti.TestingSystem6.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<AccountDTO> getAll(AccountFilterForm form){
        List<Account> accounts = accountService.getAll(form);
        return modelMapper.map(accounts, new TypeToken<List<AccountDTO>>(){}.getType());

    }
}
