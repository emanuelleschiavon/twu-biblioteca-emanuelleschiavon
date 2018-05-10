package com.twu.biblioteca.entity;

public class Book extends Item{

    public Book(Integer id, String author, Integer year, String name) {
        super(id, year, author, name);
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Author: " + this.owner + ", Year Published: " + this.year + ", Title: " + this.name;
    }

}