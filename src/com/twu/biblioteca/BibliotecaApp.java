package com.twu.biblioteca;

import com.twu.biblioteca.ui.UserInterfaceController;

public class BibliotecaApp {

    public static void main(String[] args) {
        UserInterfaceController userInterfaceController = new UserInterfaceController();

        userInterfaceController.printWelcome();

        while (true) {
            String email = userInterfaceController.getEmail();
            String password = userInterfaceController.getPassword();
            if (userInterfaceController.login(email, password)) {
                userInterfaceController.openMenu();
            }
        }
    }
}