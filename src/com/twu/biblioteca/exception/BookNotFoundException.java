package com.twu.biblioteca.exception;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(Integer id){
        super("Doesn't exist book with id = " + id + " in the Library!");
    }
}
