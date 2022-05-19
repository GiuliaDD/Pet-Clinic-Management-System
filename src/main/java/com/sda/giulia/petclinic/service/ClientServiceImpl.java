package com.sda.giulia.petclinic.service;

import com.sda.giulia.petclinic.model.Client;
import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.repository.ClientRepository;
import com.sda.giulia.petclinic.repository.ClientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public List<Pet> findPetsForClientId(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            return client.get().getPets();
        }
        return new ArrayList<>();
    }
}
