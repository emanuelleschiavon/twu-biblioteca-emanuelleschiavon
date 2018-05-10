package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MenuTest {

    private Menu menu;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void start() {
        menu = new Menu(new UserInterface());
    }

    @Test
    public void shouldHaveTwoOptionInMenu() {
        List<String> options = menu.getOptions();

        assertEquals(options.size(), 4);
    }

    @Test
    public void shouldExit() {
        exit.expectSystemExitWithStatus(0);
        menu.evaluateOption(0, new Library());
    }

    @Test
    public void shouldPrintBooks() {
        menu.evaluateOption(1, new Library());

        assertThat(systemOutRule.getLog(), containsString("Id: 1, Author: Robert Martin, Year Published:"));
    }

    @Test
    public void shouldCheckOutBookAvailable() {
        systemInMock.provideLines("3");
        menu.evaluateOption(2, new Library());

        assertThat(systemOutRule.getLog(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldCheckOutBookNotAvailable() {
        systemInMock.provideLines("99");
        menu.evaluateOption(2, new Library());

        assertThat(systemOutRule.getLog(), containsString("Doesn't exist book "));
    }

    @Test
    public void shouldGiveBackBookAvailable() {
        systemInMock.provideLines("3");
        menu.evaluateOption(3, new Library());

        assertThat(systemOutRule.getLog(), containsString("Thank you for returning the book."));
    }

    @Test
    public void shouldGiveBackBookNotAvailable() {
        systemInMock.provideLines("99");
        menu.evaluateOption(3, new Library());

        assertThat(systemOutRule.getLog(), containsString("Doesn't exist book "));
    }

    @Test
    public void shouldShowMessageOptionInvalid() {
        menu.evaluateOption(6, new Library());

        assertThat(systemOutRule.getLog(), containsString("Select a valid option!"));
    }
}
