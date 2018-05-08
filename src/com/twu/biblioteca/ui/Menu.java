package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.ui.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private List<String> options;

    public Menu() {
        this.options = new ArrayList<String>();
        addOptionsToMenu();
    }

    private void addOptionsToMenu() {
        this.options = Arrays.asList("1. List Books", "2. Check Out Book", "3. Return Book", "0. Quit");
    }

    public List<String> getOptions() {
        return options;
    }

    public void evaluateOption(Integer optionMenuNumber, UserInterface userInterface, Library library) {
        switch (optionMenuNumber) {
            case 1:
                userInterface.printBooks(library);
                break;
            case 2:
                checkOutBook(userInterface, library);
                break;
            case 3:
                giveBackBook(userInterface, library);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                userInterface.printMessageError();
                break;
        }
    }

    private void checkOutBook(UserInterface userInterface, Library library) {
        userInterface.printCheckOut();
        String bookId = userInterface.readLineConsole();
        Integer bookIdInteger = Integer.parseInt(bookId);
        Book book = library.getBookBy(bookIdInteger);
        Boolean checkOutBookWithSuccess = library.checkOut(book);
        if (checkOutBookWithSuccess){
            userInterface.printMessageCheckOutSuccess();
        }else{
            userInterface.printMessageCheckOutNotSuccess();
        }
    }

    private void giveBackBook(UserInterface userInterface, Library library) {
        userInterface.printGiveBack();
        String bookId = userInterface.readLineConsole();
        Integer bookIdInteger = Integer.parseInt(bookId);
        Book book = library.getBookBy(bookIdInteger);
        Boolean giveBackBookWithSuccess = library.giveBack(book);
        if (giveBackBookWithSuccess){
            userInterface.printMessageGiveBackSuccess();
        }else{
            userInterface.printMessageGiveBackNotSuccess();
        }
    }

}
