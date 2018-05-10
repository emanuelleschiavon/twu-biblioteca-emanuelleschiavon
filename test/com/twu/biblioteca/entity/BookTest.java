package com.twu.biblioteca.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldPrintBookInformation() {
        Book book = new Book(1, "Robert Martin", 2008, "Clean Code");

        assertEquals(book.toString(), "Id: 1, Author: Robert Martin, Year Published: 2008, Title: Clean Code");
    }

}
