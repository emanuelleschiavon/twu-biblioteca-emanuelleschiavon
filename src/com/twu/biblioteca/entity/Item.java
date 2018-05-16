package com.twu.biblioteca.entity;

public abstract class Item {
    protected Integer id;
    protected Integer year;
    protected String owner;
    protected String name;
    protected Boolean available;
    protected User userCheckOut;

    public Item(Integer id, Integer year, String owner, String name) {
        this.id = id;
        this.year = year;
        this.owner = owner;
        this.name = name;
        this.available = true;
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void checkOut(User user) {
        this.userCheckOut = user;
        this.available = false;
    }

    public void giveBack() {
        this.userCheckOut = null;
        this.available = true;
    }

}
