/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.repositories;

/**
 *
 * @author slend
 */
import com.banco.banking_management.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    @Query(value = "SELECT m.* FROM movements m " +
               "JOIN accounts a ON a.id = m.account_id " +
               "JOIN clients c ON c.id = a.client_id " +
               "WHERE c.id = :clientId " + 
               "AND m.date BETWEEN :startDate AND :endDate " +
               "AND m.is_deleted = 0", nativeQuery = true)
    List<Movement> getReportByClientNative(
        @Param("clientId") Long clientId, 
        @Param("startDate") java.time.LocalDate startDate, 
        @Param("endDate") java.time.LocalDate endDate
    );

    @Query("SELECT SUM(m.value) FROM Movement m WHERE m.account.id = :accountId " +
           "AND m.date = :date AND m.value < 0 AND m.isDeleted = false")
    Double sumWithdrawalsByAccountIdAndDate(@Param("accountId") Long accountId, @Param("date") Date date);
}

