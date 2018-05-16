package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class PrinterTest {

    private Printer printer;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        printer = new Printer();
    }

    @Test
    public void shouldPrintListAvailableBooks() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Book(1, "Robert Martin", 2008, "Clean Code"));
        printer.printAvailableItems(items);
        String printExpected = "Id: 1, Author: Robert Martin, Year Published: 2008, Title: Clean Code";

        assertThat(systemOutRule.getLog(), containsString(printExpected));
    }

    @Test
    public void shouldPrintOptionsMenu() {
        List<String> options = Arrays.asList("1. List Books", "2. Check Out Book", "3. Return Book", "0. Quit");
        printer.printOptions(options);
        String printExpected = "1. List Books\n2. Check Out Book\n3. Return Book\n0. Quit\n";

        assertThat(systemOutRule.getLog(), containsString(printExpected));
    }

    @Test
    public void shouldGetTypeNumber() {
        systemInMock.provideLines("3");
        Integer number = printer.readNumber();

        assertEquals(Integer.valueOf(3), number);
    }

    @Test
    public void shouldPrintEmail(){
        printer.requestLogin();

        assertThat(systemOutRule.getLog(), containsString("You need login in Bibli"));
    }

    @Test
    public void shouldPrintPassword(){
        printer.requestPassword();

        assertEquals(systemOutRule.getLog(), "Password: ");
    }

    @Test
    public void shouldGetLine(){
        systemInMock.provideLines("teste");
        String line = printer.readLine();

        assertEquals(line, "teste");
    }

    @Test
    public void shouldPrintCustomerInformation(){
        User user = new User("Joãozin", "joao@email.com", "1234", "9999");
        printer.printCustomerInformation(user);

        assertThat(systemOutRule.getLog(), containsString("Name: Joãozin, Email: joao@email.com, Phone Number: 9999"));
    }

}
