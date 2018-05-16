package com.twu.biblioteca.entity;

public class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Email: " + this.email + ", Phone Number: " +  this.phoneNumber;
    }

}
