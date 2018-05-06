package com.twu.biblioteca.main;

import com.twu.biblioteca.ui.Printer;

public class Main {

    public void start() {
        Printer printer = new Printer();
        printer.printWelcome();
        printer.printBooks();
    }

}
