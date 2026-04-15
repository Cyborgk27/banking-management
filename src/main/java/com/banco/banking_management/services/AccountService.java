/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.services;

/**
 *
 * @author slend
 */
import com.banco.banking_management.entities.Account;
import com.banco.banking_management.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllActiveAccounts() {
        return accountRepository.findAll().stream()
                .filter(a -> !a.isDeleted()).toList();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setAccountType(accountDetails.getAccountType());
        account.setInitialBalance(accountDetails.getInitialBalance());
        account.setStatus(accountDetails.isStatus());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        account.setDeleted(true);
        accountRepository.save(account);
    }
}