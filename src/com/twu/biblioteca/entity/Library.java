package com.twu.biblioteca.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Book> availableBooks;

    public Library() {
        this.books = new ArrayList<Book>();
        this.availableBooks = new ArrayList<Book>();
        addBooksDefault();
        addAvailableBooksDefault();
    }

    private void addBooksDefault() {
        this.books = Arrays.asList(new Book(1, "Robert Martin", 2008, "Clean Code"), new Book(2, "Andrew Hunt", 1999, "The Pragmatic Programmer"), new Book(3, "Robert Martin", 2011, "The Clean Coder"));
    }

    private void addAvailableBooksDefault() {
        for (Book book : this.books) {
            if (book.getAvailable()) {
                this.availableBooks.add(book);
            }
        }
    }

    public List<Book> listBooks() {
        return this.books;
    }

    public List<Book> listAvailableBooks() {
        return this.availableBooks;
    }

    public void addBookInLibrary(Book book) {
        this.listBooks().add(book);
        this.listAvailableBooks().add(book);
    }

    public Boolean checkOut(Book book) {
        Boolean checkOutWithSuccess = false;
        if (book.getAvailable()) {
            book.checkOut();
            this.availableBooks.remove(book);
            checkOutWithSuccess = true;
        }
        return checkOutWithSuccess;
    }

    public Boolean giveBack(Book book){
        Boolean giveBackSuccess = false;
        if(!book.getAvailable()){
            book.giveBack();
            this.availableBooks.add(book);
            giveBackSuccess = true;
        }
        return giveBackSuccess;
    }

    public Book getBookBy(Integer id) {
        Book bookSearched = null;
        for (Book book : this.books) {
            if (book.getId().equals(id)) {
                bookSearched = book;
            }
        }
        return bookSearched;
    }
}
