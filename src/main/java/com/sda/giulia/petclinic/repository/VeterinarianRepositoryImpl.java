package com.sda.giulia.petclinic.repository;

import com.sda.giulia.petclinic.model.Veterinarian;
import com.sda.giulia.petclinic.repository.base.BaseRepositoryImpl;


public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}