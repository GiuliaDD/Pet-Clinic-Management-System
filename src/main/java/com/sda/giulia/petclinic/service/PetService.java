package com.sda.giulia.petclinic.service;

import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface PetService {

    void create (String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException;

    List<Pet> findAllVaccinated();
}
