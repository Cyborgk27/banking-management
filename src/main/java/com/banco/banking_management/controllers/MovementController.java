/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.controllers;

/**
 *
 * @author slend
 */

import com.banco.banking_management.entities.Movement;
import com.banco.banking_management.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody Movement movement) {
        return ResponseEntity.ok(movementService.createMovement(movement));
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<Movement>> getReport(
        @RequestParam long clientId, 
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate endDate) {
        
        return ResponseEntity.ok(movementService.getReportByDates(clientId, startDate, endDate));
    }
}