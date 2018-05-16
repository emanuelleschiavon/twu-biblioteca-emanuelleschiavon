package com.twu.biblioteca.entity;

public class Book extends Item{

    public Book(Integer id, String author, Integer year, String name) {
        super(id, year, author, name);
    }

    @Override
    public String toString() {
        String bookInformation = "Id: " + this.id + ", Author: " + this.owner + ", Year Published: " + this.year + ", Title: " + this.name;
        if(userCheckOut == null){
            return bookInformation;
        }
        return bookInformation + ", User: " + userCheckOut.getName();
    }



}