package com.twu.biblioteca.ui;

import com.twu.biblioteca.ui.Menu;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private Menu menu;

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
    public void firstOptionShouldBeListBooks() {
        String listBooks = menu.getOptions().get(0);

        assertEquals(listBooks, "1. List Books");
    }

}