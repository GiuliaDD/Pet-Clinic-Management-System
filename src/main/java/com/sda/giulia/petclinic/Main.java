package com.sda.giulia.petclinic;

import com.sda.giulia.petclinic.controller.VeterinarianController;
import com.sda.giulia.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        veterinarianController.create();

    }
}
