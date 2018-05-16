package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.exception.ItemNotFoundException;
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
    private Library library;
    private User user;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        library = new Library();
        user = new User("João", "joao@email.com", "1234", "99999");
    }

    @Test
    public void shouldHaveOptionInMenuWhenLogged() {
        library.login(new User("Joao", "joao@email.com", "1234", "9999"));
        menu = new Menu(new Printer(), library);
        List<String> options = menu.getOptions();

        assertEquals(options.size(), 5);
    }

    @Test
    public void shouldOptionMenuHaveNotShowInformationWhenNotLogged() {
        menu = new Menu(new Printer(), library);
        List<String> options = menu.getOptions();

        assertEquals(options.size(), 4);
    }

    @Test
    public void shouldExit() {
        exit.expectSystemExitWithStatus(0);
        menu = new Menu(new Printer(), library);
        menu.evaluateOption(0);
    }

    @Test
    public void shouldPrintItems() {
        menu = new Menu(new Printer(), library);
        menu.evaluateOption(1);

        assertThat(systemOutRule.getLog(), containsString("Id: 1, Author: Robert Martin, Year Published:"));
    }

    @Test
    public void shouldCheckOutItemAvailable() {
        library.login(user);
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("3");
        menu.evaluateOption(2);

        assertThat(systemOutRule.getLog(), containsString("Thank you! Enjoy the item"));
    }

    @Test
    public void shouldNotCheckOutItemNotAvailable() throws ItemNotFoundException {
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("3");
        library.checkOutItem(3);
        menu.evaluateOption(2);

        assertThat(systemOutRule.getLog(), containsString("That book is not available."));
    }

    @Test
    public void shouldNotCheckOutItemUnExistent() {
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("99");
        menu.evaluateOption(2);

        assertThat(systemOutRule.getLog(), containsString("Doesn't exist item "));
    }

    @Test
    public void shouldGiveBackItem() throws ItemNotFoundException {
        library.login(user);
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("3");
        library.checkOutItem(3);
        menu.evaluateOption(3);

        assertThat(systemOutRule.getLog(), containsString("Thank you for returning the item."));
    }

    @Test
    public void shouldNotGiveBackItemAvailable() {
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("3");
        menu.evaluateOption(3);

        assertThat(systemOutRule.getLog(), containsString("That is not a valid book to return."));
    }

    @Test
    public void shouldNotGiveBackItemUnExistent() {
        menu = new Menu(new Printer(), library);
        systemInMock.provideLines("99");
        menu.evaluateOption(3);

        assertThat(systemOutRule.getLog(), containsString("Doesn't exist item "));
    }

    @Test
    public void shouldShowMessageOptionInvalid() {
        menu = new Menu(new Printer(), library);
        menu.evaluateOption(6);

        assertThat(systemOutRule.getLog(), containsString("Select a valid option!"));
    }

    @Test
    public void shouldShowInformationCustomer() {
        menu = new Menu(new Printer(), library);
        library.login(new User("Joaquim", "joaquim@email.com", "1234", "9999"));
        menu.evaluateOption(4);

        assertThat(systemOutRule.getLog(), containsString("Name: Joaquim, Email: joaquim@email.com, Phone Number: 9999"));
    }
}