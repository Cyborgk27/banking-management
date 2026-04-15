/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.entities;

/**
 *
 * @author slend
 */
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client extends Person {
    @Column(unique = true, nullable = false)
    private String clientId;

    private String password;
    private boolean status;
    private boolean isDeleted;
}