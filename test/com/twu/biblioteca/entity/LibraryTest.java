package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private User user;

    @Before
    public void setUp() {
        library = new Library();
        user = new User("Joao", "joao@email.com", "23456", "999999999");
    }

    @Test
    public void shouldListItemsSizeBeThree() {
        List<Item> items = library.listNotAvailableItems();

        assertEquals(items.size(), 0);
    }

    @Test
    public void shouldListItemsAvailable() {
        Item item = library.listAvailableItems().get(0);
        item.checkOut(user);
        List<Item> items = library.listAvailableItems();

        assertEquals(items.size(), 4);
    }

    @Test
    public void shouldListItemsAvailableAfterCheckOut() throws ItemNotFoundException {
        library.login(user);
        library.checkOutItem(4);
        library.checkOutItem(1);

        assertEquals(library.listAvailableItems().size(), 3);
    }

    @Test
    public void shouldListUsers(){
        List<User> users = library.listUsers();

        assertEquals(users.size(), 2);
    }

    @Test
    public void shouldLogIn(){
        User user = library.listUsers().get(0);
        library.login(user);

        assertEquals(user, library.getCurrentUser());
    }

    @Test
    public void shouldCheckOutAvailableItem() throws ItemNotFoundException {
        library.login(user);
        Boolean checkOutWithSuccess = library.checkOutItem(1);

        assertEquals(checkOutWithSuccess, true);
    }

    @Test
    public void shouldNotCheckOutUnAvailableItem() throws ItemNotFoundException {
        library.login(user);
        Boolean checkOutWithSuccess = library.checkOutItem(1);

        assertEquals(checkOutWithSuccess, true);
    }

    @Test(expected = ItemNotFoundException.class)
    public void shouldThrowItemNotFoundExceptionWhenCheckOutingUnExistentItem() throws ItemNotFoundException {
        library.checkOutItem(0);
    }

    @Test
    public void shouldGiveBackUnAvailableItem() throws ItemNotFoundException {
       library.login(user);
        library.checkOutItem(1);
        Boolean giveBackWithSuccess = library.giveBackItem(1);

        assertEquals(giveBackWithSuccess, true);
    }

    @Test
    public void shouldNotGiveBackAvailableItem() throws ItemNotFoundException {
        library.login(user);
        library.checkOutItem(1);
        Boolean giveBackWithSuccess = library.giveBackItem(1);

        assertEquals(giveBackWithSuccess, true);
    }

    @Test(expected = ItemNotFoundException.class)
    public void shouldThrowItemNotFoundExceptionWhenGiveBackingUnExistentItem() throws ItemNotFoundException {
        library.giveBackItem(0);
    }
}
