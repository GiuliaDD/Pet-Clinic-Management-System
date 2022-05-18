package com.sda.giulia.petclinic.repository;

import com.sda.giulia.petclinic.model.Client;
import com.sda.giulia.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long> {
    Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
}


