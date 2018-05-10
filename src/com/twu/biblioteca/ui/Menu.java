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
        this.options = Arrays.asList("1. List Available Books", "2. Check Out Book", "3. Return Book", "0. Quit");
    }

    public List<String> getOptions() {
        return options;
    }

    public void evaluateOption(Integer optionMenu, Library library) {
        Integer bookId;
        switch (optionMenu) {
            case 0:
                System.exit(0);
            case 1:
                userInterface.printAvailableBooks(library.listBooksAvailable());
                break;
            case 2:
                userInterface.printCheckOut();
                bookId = userInterface.readNumber();
                Boolean checkOutBook = checkOutBook(bookId, library);
                if(checkOutBook){
                    userInterface.printMessageCheckOutSuccess();
                }else{
                    userInterface.printMessageCheckOutNotSuccess();
                }
                break;
            case 3:
                userInterface.printGiveBack();
                bookId = userInterface.readNumber();
                Boolean giveBackBook = giveBackBook(bookId, library);
                if (giveBackBook){
                    userInterface.printMessageGiveBackSuccess();
                }else{
                    userInterface.printMessageGiveBackNotSuccess();
                }
                break;
            default:
                userInterface.printMessageError();
                break;
        }
    }

    private Boolean checkOutBook(Integer bookId, Library library) {
        try {
            Boolean checkOutBookWithSuccess = library.checkOutBook(bookId);
            return checkOutBookWithSuccess;
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Boolean giveBackBook(Integer bookId, Library library) {
        try {
            Boolean giveBackBookWithSuccess = library.giveBackBook(bookId);
            return giveBackBookWithSuccess;
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
