package com.twu.biblioteca.entity;

public class Book {
    private Integer id;
    private String author;
    private Integer yearPublished;
    private String title;
    private Boolean available;

    public Book(Integer id, String author, Integer yearPublished, String title) {
        this.id = id;
        this.author = author;
        this.yearPublished = yearPublished;
        this.title = title;
        this.available = true;
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void checkOut() {
        this.available = false;
    }

    public void giveBack() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Author: " + this.author + ", Year Published: " + this.yearPublished + ", Title: " + this.title + ", Is available: " + this.available;
    }

}