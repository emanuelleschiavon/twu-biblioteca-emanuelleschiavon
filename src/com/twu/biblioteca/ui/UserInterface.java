package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserInterface {

    public void printWelcome() {
        System.out.println("--------------------------------");
        System.out.println("|  Welcome to the Library!!!   |");
        System.out.println("|  Press ENTER to continue...  |");
        System.out.println("--------------------------------");
    }

    public void printBooks(Library library) {
        List<Book> books = library.listAvailableBooks();

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("| This is the Menu. Type a number option or 0 to quit: |");
        System.out.println("--------------------------------------------------------");

        Menu menu = new Menu();
        List<String> options = menu.getOptions();

        for (String option : options) {
            System.out.println(option);
        }
    }

    public void printMessageError() {
        System.out.println("Select a valid option!");
    }

    public String readLineConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error reading keyboard");
        }

        return line;
    }

    public void printMessageCheckOutSuccess() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void printMessageCheckOutNotSuccess() {
        System.out.println("That book is not available.");
    }

    public void printCheckOut(){
        System.out.println("Type the id of book that you want to check out");
    }

    public void printMessageGiveBackSuccess() {
        System.out.println("Thank you for returning the book.");
    }

    public void printMessageGiveBackNotSuccess() {
        System.out.println("That is not a valid book to return.");
    }

    public void printGiveBack(){
        System.out.println("Type the id of book that you want to give back");
    }
}
