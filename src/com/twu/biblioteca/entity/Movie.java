package com.twu.biblioteca.entity;

public class Movie extends Item {
    private Integer rating;

    public Movie(Integer id, String director, Integer year, String name, Integer rating) {
        super(id, year, director, name);
        this.rating = rating;
    }

    @Override
    public String toString() {
        String informationMovie = "Id: " + this.id + ", Director: " + this.owner + ", Year: " + this.year + ", Name: " + this.name + ", Movie Rating: " + this.rating;
        if(userCheckOut == null){
            return informationMovie;
        }
        return informationMovie + ", User: " + userCheckOut.getName();
    }
}