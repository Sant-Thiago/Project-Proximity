package com.example.beck.Led.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beck.Led.Model.Client;
import com.example.beck.Led.Repository.ClientRepository;

@Service
public class ClientService {
 
    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new Error(); 
        }
        return optionalClient.get();
    }
}
