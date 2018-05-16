package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("João", "joao@email.com", "1234", "99999");
    }

    @Test
    public void shouldPrintNameUser() {
        String name = user.toString();

        assertEquals ("Name: João, Email: joao@email.com, Phone Number: 99999",name);
    }
}
