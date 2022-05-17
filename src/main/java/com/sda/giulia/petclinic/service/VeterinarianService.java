package com.sda.giulia.petclinic.service;

import java.security.InvalidParameterException;

public interface VeterinarianService {

    void create(String firstName,String lastName,String address, String speciality) throws InvalidParameterException;
}