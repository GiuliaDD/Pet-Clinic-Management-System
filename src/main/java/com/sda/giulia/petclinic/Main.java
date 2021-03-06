package com.sda.giulia.petclinic;

import com.sda.giulia.petclinic.controller.ClientController;
import com.sda.giulia.petclinic.controller.PetController;
import com.sda.giulia.petclinic.controller.VeterinarianController;
import com.sda.giulia.petclinic.option.UserOption;
import com.sda.giulia.petclinic.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        PetController petController = new PetController();
        ClientController clientController = new ClientController();
        Scanner scanner = new Scanner(System.in);

        UserOption option = UserOption.UNKNOWN;
        do {
           UserOption.printAllOptions();
           System.out.println("Choose an option.");
           String inputOption = scanner.nextLine();
           try{
               int userOption = Integer.parseInt(inputOption);
               option=UserOption.findBy(userOption).orElse(UserOption.UNKNOWN);
           } catch(NumberFormatException e){
               option = UserOption.UNKNOWN;
           }
            System.out.println(option.getPrettyName());
           switch (option){
               case ADD_NEW_VET:
                   veterinarianController.create();
                   break;
               case SHOW_ALL:
                   veterinarianController.showAllVeterinarians();
                   break;
               case DELETE_BY_ID:
                   veterinarianController.deleteById();
                   break;
               case UPDATE:
                   veterinarianController.update();
                   break;
               case ADD_NEW_PET:
                   petController.addPet();
                   break;
               case VIEW_ALL_VACCINATED:
                   petController.showAllVaccinated();
                   break;
               case VIEW_ALL_PETS_FOR_CLIENT_ID:
                   clientController.viewAllPetsForClient();
                   break;
               case UNKNOWN:
                   break;
               case EXIT:
                   System.out.println("Goodbye!");
                   break;
               default:
                   System.out.println("This option is not implemented.");
                   break;
           }

        } while (!option.equals(UserOption.EXIT));
        SessionManager.shutdown();
    }
}
