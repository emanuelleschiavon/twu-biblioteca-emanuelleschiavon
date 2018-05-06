package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<Book>();
        addBooksDefault();
    }

    private void addBooksDefault() {
        this.books = Arrays.asList(new Book("Robert Martin", 2008, "Clean Code"),
                new Book("Andrew Hunt", 1999, "The Pragmatic Programmer"),
                new Book("Robert Martin", 2011, "The Clean Coder"));
    }

    public List<Book> listBooks(){
        return this.books;
    }

}
