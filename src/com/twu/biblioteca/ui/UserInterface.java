package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public void printWelcome() {
        System.out.println("--------------------------------");
        System.out.println("|  Welcome to the Library!!!   |");
        System.out.println("|  Press ENTER to continue...  |");
        System.out.println("--------------------------------");
    }

    public void printBooks(List<Book> books) {

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printOptions(List<String> options) {
        System.out.println("--------------------------------------------------------");
        System.out.println("| This is the Menu. Type a number option or 0 to quit: |");
        System.out.println("--------------------------------------------------------");

        for (String option : options) {
            System.out.println(option);
        }
    }

    public void printMessageError() {
        System.out.println("Select a valid option!");
    }

    public Integer readNumber() {
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        return number;
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
