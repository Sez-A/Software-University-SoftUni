package com.example.springdataintro.services;

import com.example.springdataintro.entites.Account;

import java.math.BigDecimal;

public interface UserService {
    void registerUser(String username, int age, BigDecimal initialAmount);
}
