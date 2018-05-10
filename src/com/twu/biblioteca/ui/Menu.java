package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.exception.ItemNotFoundException;

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
        Integer itemId;
        switch (optionMenu) {
            case 0:
                System.exit(0);
            case 1:
                userInterface.printAvailableItems(library.listAvailableItems());
                break;
            case 2:
                userInterface.printCheckOut();
                itemId = userInterface.readNumber();
                Boolean checkOutBook = checkOutItem(itemId, library);
                if(checkOutBook){
                    userInterface.printMessageCheckOutSuccess();
                }else{
                    userInterface.printMessageCheckOutNotSuccess();
                }
                break;
            case 3:
                userInterface.printGiveBack();
                itemId = userInterface.readNumber();
                Boolean giveBackItem = giveBackItem(itemId, library);
                if (giveBackItem){
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

    private Boolean checkOutItem(Integer itemId, Library library) {
        try {
            Boolean checkOutItemWithSuccess = library.checkOutItem(itemId);
            return checkOutItemWithSuccess;
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Boolean giveBackItem(Integer itemId, Library library) {
        try {
            Boolean giveBackItemWithSuccess = library.giveBackItem(itemId);
            return giveBackItemWithSuccess;
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
