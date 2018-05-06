package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;

import java.io.*;
import java.util.List;

public class Printer {

    public void printWelcome() {
        System.out.println("Welcome to the Library!!!");
        System.out.println("Press ENTER to continue...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao ler teclado");
        }
    }

    public void printBooks() {
        Library library = new Library();
        List<Book> books = library.listBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
