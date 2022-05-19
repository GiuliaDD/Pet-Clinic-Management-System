package com.sda.giulia.petclinic.repository;

import com.sda.giulia.petclinic.model.Pet;
import com.sda.giulia.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.giulia.petclinic.utils.SessionManager;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }


    @Override
    public List<Pet> findAllVaccinated() {
        try{
            Session session = SessionManager.getSessionFactory().openSession();
            List<Pet> pets = session.createQuery("FROM Pet p WHERE p.isVaccinated=true").list();
            session.close();
            return pets;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
