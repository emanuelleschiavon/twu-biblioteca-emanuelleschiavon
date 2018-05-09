package com.twu.biblioteca;

import com.twu.biblioteca.ui.Menu;
import com.twu.biblioteca.ui.UserInterface;

public class Main {

    public void start() {
        UserInterface userInterface = new UserInterface();

        userInterface.printWelcome();
        userInterface.readLineConsole();

        while (true){
            userInterface.printMenu();
            String optionMenu = userInterface.readLineConsole();
            Menu menu = new Menu(userInterface);
            Integer optionNumberInteger = -1;
            try{
                optionNumberInteger = Integer.parseInt(optionMenu);
            }catch(NumberFormatException e){
                System.out.println("Type a number!");
            }
            finally {
                menu.evaluateOption(optionNumberInteger);
            }
        }
    }

}
