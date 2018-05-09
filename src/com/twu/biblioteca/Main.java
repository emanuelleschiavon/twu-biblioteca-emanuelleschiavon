package com.twu.biblioteca;

import com.twu.biblioteca.ui.Menu;
import com.twu.biblioteca.ui.UserInterface;

public class Main {

    public void start() {
        UserInterface userInterface = new UserInterface();

        userInterface.printWelcome();
        userInterface.readNumber();

        while (true) {
            Menu menu = new Menu(userInterface);
            userInterface.printOptions(menu.getOptions());
            Integer optionMenu = userInterface.readNumber();
            menu.evaluateOption(optionMenu);
        }
    }

}
