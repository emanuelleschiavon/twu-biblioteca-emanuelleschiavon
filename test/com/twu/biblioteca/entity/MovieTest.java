package com.twu.biblioteca.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldPrintBookInformation() {
        Movie movie = new Movie(1, "Quentin Tarantino", 2013, "Django Unchained", 10);

        assertEquals(movie.toString(), "Id: 1, Director: Quentin Tarantino, Year: 2013, Name: Django Unchained, Movie Rating: 10");
    }

    @Test
    public void shouldPrintBookInformationNotAvailable() {
        Movie movie = new Movie(1, "Quentin Tarantino", 2013, "Django Unchained", 10);
        movie.checkOut(new User("João", "joao@email.com", "1234", "9999"));

        assertEquals(movie.toString(), "Id: 1, Director: Quentin Tarantino, Year: 2013, Name: Django Unchained, Movie Rating: 10, User: João");
    }
}
