package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.User;

import java.util.List;
import java.util.Scanner;

public class Printer {

    public void printItems(List<Item> items) {
        if (items.size() > 0){
            for (Item item : items) {
                System.out.println(item);
            }
        }else{
            System.out.println("There aren't items!!!");
        }
    }

    public void printOptions(List<String> options) {
        System.out.println("------------------------------------------");
        System.out.println("| This is the Menu. Type a number option: |");
        System.out.println("------------------------------------------");

        for (String option : options) {
            System.out.println(option);
        }
    }

    public Integer readNumber() {
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        return number;
    }

    public void printMessageCheckOutSuccess() {
        System.out.println("Thank you! Enjoy the item");
    }

    public void printMessageCheckOutNotSuccess() {
        System.out.println("That book is not available.");
    }

    public void printCheckOut() {
        System.out.println("Type the id of book that you want to check out");
    }

    public void printMessageGiveBackSuccess() {
        System.out.println("Thank you for returning the item.");
    }

    public void printMessageGiveBackNotSuccess() {
        System.out.println("That is not a valid book to return.");
    }

    public void printGiveBack() {
        System.out.println("Type the id of book that you want to give back");
    }

    public void printMessageError() {
        System.out.println("Select a valid option!");
    }

    public void requestLogin() {
        System.out.println("Hello, You need login in Biblioteca to move on...");
        System.out.print("Email: ");
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        return line;
    }

    public void requestPassword() {
        System.out.print("Password: ");
    }

    public void printCustomerInformation(User user) {
        System.out.println("Self Information");
        System.out.println(user.toString());
    }

}
