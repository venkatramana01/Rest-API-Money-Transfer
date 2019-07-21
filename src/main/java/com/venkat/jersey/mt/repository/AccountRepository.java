package com.venkat.jersey.mt.repository;



import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.venkat.jersey.mt.error.DuplicateAccountException;
import com.venkat.jersey.mt.model.Account;


public class AccountRepository {

    private static final AccountRepository INSTANCE=new AccountRepository();
    //private final Map<String, Account> accounts=new ConcurrentHashMap<String, Account>();
    private static final Map<String, Account> accounts=new HashMap<String, Account>();;
    /*private AccountRepository(Map<String, Account> accounts) {
        this.accounts = accounts;
    }*/
    private AccountRepository() {
    }
    
    public static AccountRepository getInstance() {
        return INSTANCE;
    }


    public Account getById(String id) {
        return accounts.get(id);
    }

    public Collection<Account> getAll() {
        return accounts.values();
    }

    public Account addAccount(Account account) {
        Account accountExists = accounts.putIfAbsent(account.getId(), account);
        if (accountExists != null) {
            throw new DuplicateAccountException(accountExists.getId());
        }

        return getById(account.getId());
    }

    public void removeAll() {
        synchronized (accounts) {
            accounts.clear();
        }
    }
}