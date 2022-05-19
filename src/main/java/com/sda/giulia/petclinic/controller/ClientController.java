package com.sda.giulia.petclinic.controller;

import com.sda.giulia.petclinic.service.ClientService;
import com.sda.giulia.petclinic.service.ClientServiceImpl;

import java.util.Scanner;

public class ClientController {
    private final ClientService clientService;
    private final Scanner scanner;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void viewAllPetsForClient() {
        try {
            System.out.println("Please insert client ID: ");
            Long inputClientId = Long.parseLong(scanner.nextLine());
            clientService.findPetsForClientId(inputClientId).stream()
                    .forEach(pet -> System.out.println(pet));

        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid client ID.");
        } catch (Exception e) {
            System.out.println("Internal server error.");
            e.printStackTrace();
        }
    }
}
