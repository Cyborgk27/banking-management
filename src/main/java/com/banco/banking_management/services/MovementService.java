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
import com.banco.banking_management.entities.Movement;
import com.banco.banking_management.repositories.AccountRepository;
import com.banco.banking_management.repositories.MovementRepository;
import exceptions.UserFriendlyException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountRepository accountRepository;

    private static final double DAILY_LIMIT = 1000.0;

    @Transactional
    public Movement createMovement(Movement movement) {

        Account account = accountRepository.findById(movement.getAccount().getId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double currentBalance = account.getInitialBalance();
        double amount = movement.getValue();

        if (amount < 0 && Math.abs(amount) > currentBalance) {
            throw new UserFriendlyException("Saldo no disponible");
        }

        if (amount < 0) {
            Double totalWithdrawnToday = movementRepository.sumWithdrawalsByAccountIdAndDate(account.getId(), new Date());
            double totalWithToday = (totalWithdrawnToday != null ? Math.abs(totalWithdrawnToday) : 0) + Math.abs(amount);
            
            if (totalWithToday > DAILY_LIMIT) {
                throw new UserFriendlyException("Cupo diario excedido");
            }
        }

        double newBalance = currentBalance + amount;
        account.setInitialBalance(newBalance);
        accountRepository.save(account);

        movement.setBalance(newBalance);
        movement.setDate(new Date());
        return movementRepository.save(movement);
    }

    public List<Movement> getReportByDates(long clientId, LocalDate start, LocalDate end) {
        return movementRepository.getReportByClientNative(clientId, start, end);
    }
}