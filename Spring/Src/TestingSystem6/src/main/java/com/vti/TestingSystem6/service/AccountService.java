package com.vti.TestingSystem6.service;

import com.vti.TestingSystem6.entity.Account;
import com.vti.TestingSystem6.form.AccountFilterForm;
import com.vti.TestingSystem6.repository.IAccountRepository;
import com.vti.TestingSystem6.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public List<Account> getAll(AccountFilterForm form) {
        Specification<Account> where = AccountSpecification.buildWhere(form);
        return accountRepository.findAll();
    }
}
