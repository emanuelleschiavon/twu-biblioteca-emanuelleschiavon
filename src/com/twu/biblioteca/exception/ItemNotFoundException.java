package com.twu.biblioteca.exception;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(Integer id){
        super("Doesn't exist item with id = " + id + " in the Biblioteca!");
    }
}
