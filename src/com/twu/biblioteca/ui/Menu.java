package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private List<String> options;
    private Printer printer;
    private Library library;

    public Menu(Printer printer, Library library) {
        this.printer = printer;
        this.library = library;
        this.options = new ArrayList<String>();
        addOptionsToMenu();
    }

    private void addOptionsToMenu() {
        this.options = Arrays.asList("1. List Available Books", "2. Check Out Book", "3. Return Book", "4. Show My Information", "5. List Not Available Items", "0. Quit");
    }

    public List<String> getOptions() {
        List<String> modifiableListOptions = new ArrayList<String>(this.options);
        Boolean isLogged = library.getCurrentUser() != null;
        if (isLogged) {
            return modifiableListOptions;
        }
        modifiableListOptions.remove(3);
        return modifiableListOptions;
    }

    public void evaluateOption(Integer optionMenu) {
        Integer itemId;
        switch (optionMenu) {
            case 0:
                System.exit(0);
            case 1:
                printer.printItems(library.listAvailableItems());
                break;
            case 2:
                printer.printCheckOut();
                itemId = printer.readNumber();
                Boolean checkOutBook = checkOutItem(itemId, library);
                if (checkOutBook) {
                    printer.printMessageCheckOutSuccess();
                } else {
                    printer.printMessageCheckOutNotSuccess();
                }
                break;
            case 3:
                printer.printGiveBack();
                itemId = printer.readNumber();
                Boolean giveBackItem = giveBackItem(itemId, library);
                if (giveBackItem) {
                    printer.printMessageGiveBackSuccess();
                } else {
                    printer.printMessageGiveBackNotSuccess();
                }
                break;
            case 4:
                if (library.getCurrentUser() != null) {
                    printer.printCustomerInformation(library.getCurrentUser());
                    break;
                }
            case 5:
                printer.printItems(library.listNotAvailableItems());
                break;
            default:
                printer.printMessageError();
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
