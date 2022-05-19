package com.sda.giulia.petclinic.service;

import com.sda.giulia.petclinic.model.Client;
import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.repository.ClientRepository;
import com.sda.giulia.petclinic.repository.ClientRepositoryImpl;
import com.sda.giulia.petclinic.repository.PetRepository;
import com.sda.giulia.petclinic.repository.PetRepositoryImpl;
import com.sda.giulia.petclinic.service.exception.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException {
        if(race== null || race.isBlank()){
           throw new InvalidParameterException("The race is null or blank.");
        }
        if(birthDate== null){
            throw new InvalidParameterException("The birthDate is null.");
        }
        if(birthDate.after(new Date())){
            throw new InvalidParameterException("The birthDate is in the future.");
        }
        if(ownerFirstName == null || ownerFirstName.isBlank()){
            throw new InvalidParameterException("The owner's first name is null or blank");
        }
        if(ownerLastName == null || ownerLastName.isBlank()){
            throw new InvalidParameterException("The owner's LAST name is null or blank");
        }

        Optional<Client> clientResult = clientRepository.findByFirstNameAndLastName(ownerFirstName,ownerLastName);
        if(clientResult.isEmpty()){
            Client client = new Client(ownerFirstName, ownerLastName, null, null);
            clientRepository.create(client);
            clientResult = Optional.of(client);
        }

        Pet pet = new Pet(race, birthDate, isVaccinated);
        pet.setOwner(clientResult.get());
        petRepository.create(pet);
    }

    @Override
    public List<Pet> findAllVaccinated() {
        return petRepository.findAllVaccinated();
    }
}
