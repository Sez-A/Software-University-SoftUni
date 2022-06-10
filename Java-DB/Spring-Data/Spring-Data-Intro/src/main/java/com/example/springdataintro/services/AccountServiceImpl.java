package com.example.springdataintro.services;

import com.example.springdataintro.entites.Account;
import com.example.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws IllegalArgumentException {
        Account account = this.getAccount(id);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("There isn't that much money in this account!");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }


    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        Account account = this.getAccount(id);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferBetweenAccounts(Long from, Long to, BigDecimal amount) {
        this.withdrawMoney(amount, from);
        this.transferMoney(amount, to);
    }

    private Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }
}
