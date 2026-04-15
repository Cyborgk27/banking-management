/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
/**
 *
 * @author slend
 */
@MappedSuperclass
public class Person {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long id;
   private String name;
   private String gender;
   private int age;
   private String identification;
   private String address;
   private String phone;

   public Person() {
   }

   @Generated
   public Long getId() {
      return this.id;
   }

   @Generated
   public String getName() {
      return this.name;
   }

   @Generated
   public String getGender() {
      return this.gender;
   }

   @Generated
   public int getAge() {
      return this.age;
   }

   @Generated
   public String getIdentification() {
      return this.identification;
   }

   @Generated
   public String getAddress() {
      return this.address;
   }

   @Generated
   public String getPhone() {
      return this.phone;
   }

   @Generated
   public void setId(final Long id) {
      this.id = id;
   }

   @Generated
   public void setName(final String name) {
      this.name = name;
   }

   @Generated
   public void setGender(final String gender) {
      this.gender = gender;
   }

   @Generated
   public void setAge(final int age) {
      this.age = age;
   }

   @Generated
   public void setIdentification(final String identification) {
      this.identification = identification;
   }

   @Generated
   public void setAddress(final String address) {
      this.address = address;
   }

   @Generated
   public void setPhone(final String phone) {
      this.phone = phone;
   }
}