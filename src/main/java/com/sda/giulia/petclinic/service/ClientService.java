package com.sda.giulia.petclinic.service;

import com.sda.giulia.petclinic.model.Pet;

import java.util.List;

public interface ClientService {
    List<Pet> findPetsForClientId(Long clientId);

}
