package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;

    @Before
    public void start(){
        library = new Library();
    }

    @Test
    public void listBooksDefaultShouldHaveThreeElements() {
        List<Book> books = library.listBooks();

        assertEquals(books.size(), 3);
    }

    @Test
    public void listBooksAuthorOfFirstBook(){
        Book book = library.listBooks().get(0);

        assertEquals(book.getAuthor(), "Robert Martin");
    }
}
