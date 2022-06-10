package com.example.springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id) throws IllegalArgumentException;

    void transferMoney(BigDecimal amount, Long id);

    void transferBetweenAccounts(Long from, Long to, BigDecimal amount);
}
