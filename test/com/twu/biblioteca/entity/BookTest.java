package com.twu.biblioteca.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldPrintInformation(){
        Book book = new Book(1, "Robert Martin", 2008, "Clean Code" );

        assertEquals(book.toString(), "Id: 1, Author: Robert Martin, Year Published: 2008, Title: Clean Code");
    }

    @Test
    public void shouldCheckOutBook(){
        Book book = new Book(1, "Robert Martin", 2008, "Clean Code");
        book.checkOut();

        assertEquals(book.getAvailable(), false);
    }

    @Test
    public void shouldGiveBackBookToLibrary(){
        Book book = new Book(1, "Robert Martin", 2008, "Clean Code");
        book.giveBack();

        assertEquals(book.getAvailable(), true);
    }
}
