package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private List<String> options;
    private UserInterface userInterface;

    public Menu(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.options = new ArrayList<String>();
        addOptionsToMenu();
    }

    private void addOptionsToMenu() {
        this.options = Arrays.asList("1. List Books", "2. Check Out Book", "3. Return Book", "0. Quit");
    }

    public List<String> getOptions() {
        return options;
    }

    public void evaluateOption(Integer optionMenu) {
        Library library = new Library();
        switch (optionMenu) {
            case 1:
                userInterface.printBooks(library.listBooksAvailable());
                break;
            case 2:
                checkOutBook(library);
                break;
            case 3:
                giveBackBook(library);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                userInterface.printMessageError();
                break;
        }
    }

    private void checkOutBook(Library library) {
        userInterface.printCheckOut();
        Integer bookId = userInterface.readNumber();
        try {
            Boolean checkOutBookWithSuccess = library.checkOutBook(bookId);
            if (checkOutBookWithSuccess) {
                userInterface.printMessageCheckOutSuccess();
            } else {
                userInterface.printMessageCheckOutNotSuccess();
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void giveBackBook(Library library) {
        userInterface.printGiveBack();
        Integer bookId = userInterface.readNumber();
        try {
            Boolean giveBackBookWithSuccess = library.giveBackBook(bookId);
            if (giveBackBookWithSuccess) {
                userInterface.printMessageGiveBackSuccess();
            } else {
                userInterface.printMessageGiveBackNotSuccess();
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
