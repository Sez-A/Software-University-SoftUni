package com.example.springdataintro.services;

import com.example.springdataintro.entites.Account;
import com.example.springdataintro.entites.User;
import com.example.springdataintro.repositories.AccountRepository;
import com.example.springdataintro.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);

        this.userRepository.save(user);
        Account account = new Account();
        account.setUser(user);
        account.setBalance(initialAmount);
        this.accountRepository.save(account);

    }
}
