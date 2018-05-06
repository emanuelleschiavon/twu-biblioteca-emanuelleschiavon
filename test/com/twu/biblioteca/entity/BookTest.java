package com.twu.biblioteca.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldPrintInformation(){
        Book book = new Book("Robert Martin", 2008, "Clean Code" );

        assertEquals(book.toString(), "Author: Robert Martin, Year Published: 2008, Title: Clean Code");
    }

}
