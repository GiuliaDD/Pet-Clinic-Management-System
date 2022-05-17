package com.sda.giulia.petclinic.controller;

import com.sda.giulia.petclinic.service.VeterinarianService;
import com.sda.giulia.petclinic.service.VeterinarianServiceImpl;
import com.sda.giulia.petclinic.service.dto.VeterinarianDto;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VeterinarianController {

    private final VeterinarianService veterinarianService;
    private Scanner scanner;

    public VeterinarianController() {
        this.veterinarianService = new VeterinarianServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void create() {
        try {
            System.out.println("Please insert first name:");
            String firstName = scanner.nextLine();
            System.out.println("Please insert last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the address:");
            String address = scanner.nextLine();
            System.out.println("Please insert the speciality:");
            String speciality = scanner.nextLine();

            veterinarianService.create(firstName, lastName, address, speciality);
            System.out.println("The veterinarian " + firstName + " was created.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("The veterinarian was not created, internal server error.");
        }
    }

    public void showAllVeterinarians() {
        List<VeterinarianDto> veterinariansDto = veterinarianService.findAll();
        if(veterinariansDto.isEmpty()){
            System.out.println("No veterinarians");
            return;
        }
        veterinariansDto.stream()
                .forEach(veterinarianDto ->
                        System.out.println(
                                "\n ID: " + veterinarianDto.getId() +
                                "\n  First Name: " + veterinarianDto.getFirstName() +
                                "\n  Last Name: " + veterinarianDto.getLastName() +
                                "\n  Address: " + veterinarianDto.getAddress() +
                                "\n  Speciality: " + veterinarianDto.getSpeciality()
                        )
                );
    }

    public void deleteById(){
        try{
            System.out.println("Please insert the veterinarian id: ");
            String idString = scanner.nextLine();
            Long id = Long.parseLong(idString);
            veterinarianService.deleteById(id);
            System.out.println("Vet was successfully deleted.");
        } catch (NumberFormatException e){
            System.out.println("Invalid parameter.");
        }
    }
}
