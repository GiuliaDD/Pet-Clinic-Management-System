package com.sda.giulia.petclinic.repository;

import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet, Long> {

    List<Pet> findAllVaccinated();
}
