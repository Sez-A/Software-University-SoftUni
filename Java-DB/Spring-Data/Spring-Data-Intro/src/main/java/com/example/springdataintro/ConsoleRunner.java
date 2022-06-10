package com.example.springdataintro;

import com.example.springdataintro.entites.Account;
import com.example.springdataintro.entites.User;
import com.example.springdataintro.repositories.AccountRepository;
import com.example.springdataintro.repositories.UserRepository;
import com.example.springdataintro.services.AccountService;
import com.example.springdataintro.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final AccountService accountService;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public ConsoleRunner(UserService userService, AccountService accountService,
                         UserRepository userRepository,
                         AccountRepository accountRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Account account =
                accountRepository.findById(1L).orElseThrow();
        User user = account.getUser();
        Set<Account> accounts = user.getAccounts();
        for (Account a : accounts) {
            System.out.println(a.getBalance());
        }
//        System.out.println(user.getUsername() + " " + user.getAge());
    }
}
