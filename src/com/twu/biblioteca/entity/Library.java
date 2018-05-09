package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
        addBooksDefault();
    }

    private void addBooksDefault() {
        this.books = Arrays.asList(new Book(1, "Robert Martin", 2008, "Clean Code"), new Book(2, "Andrew Hunt", 1999, "The Pragmatic Programmer"), new Book(3, "Robert Martin", 2011, "The Clean Coder"));
    }

    public List<Book> listBooks() {
        return this.books;
    }

    public List<Book> listBooksAvailable() {
        List<Book> booksAvailable = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getAvailable()) {
                booksAvailable.add(book);
            }
        }
        return booksAvailable;
    }

    public Boolean checkOutBook(Integer bookId) throws BookNotFoundException {
        Boolean checkOutWithSuccess = false;
        Book book = getBookBy(bookId);
        if (book.getAvailable()) {
            book.checkOut();
            checkOutWithSuccess = true;
        }
        return checkOutWithSuccess;
    }

    public Boolean giveBackBook(Integer bookId) throws BookNotFoundException {
        Boolean giveBackSuccess = false;
        Book book = getBookBy(bookId);
        if (!book.getAvailable()) {
            book.giveBack();
            giveBackSuccess = true;
        }
        return giveBackSuccess;
    }

    private Book getBookBy(Integer id) throws BookNotFoundException {
        for (Book book : this.books) {
            if (id.equals(book.getId())) {
                return book;
            }
        }
        throw new BookNotFoundException(id);
    }
}
