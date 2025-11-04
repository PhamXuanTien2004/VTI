package vti.dtn.account_service.service;

import vti.dtn.account_service.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getListAccounts();
}
