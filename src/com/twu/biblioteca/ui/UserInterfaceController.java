package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;

public class UserInterfaceController {

    private Library library;
    private Printer printer;

    public UserInterfaceController() {
        printer = new Printer();
        library = new Library();
    }

    public String getEmail() {
        printer.requestLogin();

        return printer.readLine();
    }

    public String getPassword() {
        printer.requestPassword();

        return printer.readLine();
    }

    public Boolean login(String email, String senha) {
        for (User user : library.listUsers()) {
            if (email.equals(user.getEmail()) && senha.equals(user.getPassword())) {
                library.login(user);
                return true;
            }
        }
        return false;
    }

    public void printWelcome() {
        System.out.println("---------------------");
        System.out.println("|  Welcome to the   |");
        System.out.println("|    LIBRARY...     |");
        System.out.println("---------------------");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openMenu() {
        Menu menu = new Menu(printer, library);
        while(true){
            printer.printOptions(menu.getOptions());
            Integer optionMenu = printer.readNumber();
            menu.evaluateOption(optionMenu);

        }
    }
}
