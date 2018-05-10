package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void shouldListBooksSizeBeThree() {
        List<Book> books = library.listBooks();

        assertEquals(books.size(), 3);
    }

    @Test
    public void shouldListBooksAvailable(){
        Book book = library.listBooks().get(0);
        book.checkOut();
        List<Book> books = library.listBooksAvailable();

        assertEquals(books.size(), 2);
    }

    @Test
    public void shouldListBooksAvailableAfterCheckOut() throws BookNotFoundException {
        library.checkOutBook(2);
        library.checkOutBook(1);

        assertEquals(library.listBooksAvailable().size(), 1);
    }

    @Test
    public void shouldCheckOutBookAvailable() throws BookNotFoundException {
        Boolean checkOutWithSuccess = library.checkOutBook(1);

        assertEquals(checkOutWithSuccess, true);
    }

    @Test(expected = BookNotFoundException.class)
    public void shouldThrowBookNotFoundExceptionWhenCheckOutingUnExistentBook() throws BookNotFoundException {
        library.checkOutBook(0);
    }

    @Test
    public void shouldGiveBackBook() throws BookNotFoundException {
        library.checkOutBook(1);
        Boolean giveBackWithSuccess = library.giveBackBook(1);

        assertEquals(giveBackWithSuccess, true);
    }

    @Test(expected = BookNotFoundException.class)
    public void shouldThrowBookNotFoundExceptionWhenGiveBackingUnExistentBook() throws BookNotFoundException {
        library.giveBackBook(999);
    }
}
