package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserInterfaceTest {

    private UserInterface userInterface;

    @Before
    public void setUp() {
        userInterface = new UserInterface();
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void shouldPrintListBooks() {
        List<Book> books = Arrays.asList(new Book(1, "Robert Martin", 2008, "Clean Code"), new Book(2, "Andrew Hunt", 1999, "The Pragmatic Programmer"), new Book(3, "Robert Martin", 2011, "The Clean Coder"));
        userInterface.printAvailableBooks(books);
        String printExpected = "Id: 1, Author: Robert Martin, Year Published: 2008, Title: Clean Code";

        assertThat(systemOutRule.getLog(), containsString(printExpected));
    }

    @Test
    public void shouldPrintOptionsMenu() {
        List<String> options = Arrays.asList("1. List Books", "2. Check Out Book", "3. Return Book", "0. Quit");
        userInterface.printOptions(options);
        String printExpected = "1. List Books\n2. Check Out Book\n3. Return Book\n0. Quit\n";

        assertThat(systemOutRule.getLog(), containsString(printExpected));
    }

    @Test
    public void shouldGetTypeNumber(){
        systemInMock.provideLines("3");
        Integer number = userInterface.readNumber();

        assertEquals(Integer.valueOf(3), number);
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        userInterface.printWelcome();

        assertThat(systemOutRule.getLog(), containsString("Welcome"));
    }

}