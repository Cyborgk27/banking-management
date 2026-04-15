/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.banking_management.services;

/**
 *
 * @author slend
 */
import com.banco.banking_management.entities.Client;
import com.banco.banking_management.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllActiveClients() {
        return clientRepository.findByIsDeletedFalse();
    }

    public Client getClientById(String clientId) {
        return clientRepository.findByClientIdAndIsDeletedFalse(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    
    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        client.setName(clientDetails.getName());
        client.setAddress(clientDetails.getAddress());
        client.setPhone(clientDetails.getPhone());
        client.setPassword(clientDetails.getPassword());
        client.setStatus(clientDetails.isStatus());
        client.setGender(clientDetails.getGender());
        client.setAge(clientDetails.getAge());

        return clientRepository.save(client);
    }   

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        client.setDeleted(true); // Soft Delete
        clientRepository.save(client);
    }
}
