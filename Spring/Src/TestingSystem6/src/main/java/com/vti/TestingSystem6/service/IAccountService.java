package com.vti.TestingSystem6.service;

import com.vti.TestingSystem6.entity.Account;
import com.vti.TestingSystem6.form.AccountFilterForm;

import java.util.List;

public interface IAccountService {
    List<Account> getAll(AccountFilterForm form);
}
