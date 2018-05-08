package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;

    @Before
    public void start() {
        library = new Library();
    }

    @Test
    public void listBooksSizeShouldBeThree() {
        List<Book> books = library.listBooks();

        assertEquals(books.size(), 3);
    }

    @Test
    public void firstBookAuthorShouldBeThis() {
        Book book = library.listBooks().get(0);

        assertEquals(book.getAuthor(), "Robert Martin");
    }

    @Test
    public void listAvailableBooksSizeShouldBeThree() {
        List<Book> availableBooks = library.listAvailableBooks();

        assertEquals(availableBooks.size(), 3);
    }

    @Test
    public void firstBookAvailableAuthorShouldBeThis() {
        Book book = library.listAvailableBooks().get(0);

        assertEquals(book.getAuthor(), "Robert Martin");
    }

    @Test
    public void shouldGetBookFromId1(){
        Book bookWithId1 = library.getBookBy(1);

        assertEquals(library.listBooks().get(0), bookWithId1);
    }

    @Test
    public void shouldCheckOutBook(){
        Book book = new Book(4, "Kathy Sierra", 2005, "Head First Java");
        book.checkOut();
        library.checkOut(book);

        assertEquals(library.listAvailableBooks().contains(book), false);
    }

    @Test
    public void shouldGiveBack(){
        Book book = new Book(4, "Kathy Sierra", 2005, "Head First Java");
        library.checkOut(book);

        assertEquals(library.listAvailableBooks().contains(book), false);
    }
}
