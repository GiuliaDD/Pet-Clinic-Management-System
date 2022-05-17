package com.sda.giulia.petclinic.service;


import com.sda.giulia.petclinic.service.dto.VeterinarianDto;
import com.sda.giulia.petclinic.service.exception.InvalidParameterException;

import java.util.List;


public interface VeterinarianService {

    void create(String firstName,String lastName,String address, String speciality) throws InvalidParameterException;

    List<VeterinarianDto> findAll();
}