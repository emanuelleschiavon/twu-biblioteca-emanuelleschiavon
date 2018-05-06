package com.twu.biblioteca.entity;

public class Book {
    private String author;
    private Integer yearPublished;
    private String title;

    public Book(String author, Integer yearPublished, String title) {
        this.author = author;
        this.yearPublished = yearPublished;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Author: " + this.author + ", Year Published: " + this.yearPublished + ", Title: "+ this.title;
    }
}
