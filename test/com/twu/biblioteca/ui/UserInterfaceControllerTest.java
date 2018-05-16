package com.twu.biblioteca.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserInterfaceControllerTest {

    private UserInterfaceController userInterfaceController;

    @Before
    public void setUp() {
        userInterfaceController = new UserInterfaceController();
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldPrintWelcomeMessage() {
        userInterfaceController.printWelcome();

        assertThat(systemOutRule.getLog(), containsString("Welcome"));
    }

    @Test
    public void shouldLogIn() {
        Boolean loginSuccess = userInterfaceController.login("joao@email.com", "1234");

        assertTrue(loginSuccess);
    }

    @Test
    public void shouldNotLogIn() {
        Boolean loginSuccess = userInterfaceController.login("joaoaaa@email.com", "1234");

        assertFalse(loginSuccess);
    }

    @Test
    public void shouldGetEmailConsole() {
        systemInMock.provideLines("mais um teste");
        String email = userInterfaceController.getEmail();

        assertEquals(email, "mais um teste");
    }

    @Test
    public void shouldGetPasswordConsole() {
        systemInMock.provideLines("mais um teste");
        String password = userInterfaceController.getPassword();

        assertEquals(password, "mais um teste");
    }

}