package com.sda.giulia.petclinic.repository;

import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.repository.base.BaseRepositoryImpl;


public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
