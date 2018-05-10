package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void shouldListItemsSizeBeThree() {
        List<Item> items = library.listItems();

        assertEquals(items.size(), 5);
    }

    @Test
    public void shouldListItemsAvailable(){
        Item item = library.listItems().get(0);
        item.checkOut();
        List<Item> items = library.listAvailableItems();

        assertEquals(items.size(), 4);
    }

    @Test
    public void shouldListItemsAvailableAfterCheckOut() throws ItemNotFoundException {
        library.checkOutItem(4);
        library.checkOutItem(1);

        assertEquals(library.listAvailableItems().size(), 3);
    }

    @Test
    public void shouldCheckOutItemAvailable() throws ItemNotFoundException {
        Boolean checkOutWithSuccess = library.checkOutItem(1);

        assertEquals(checkOutWithSuccess, true);
    }

    @Test(expected = ItemNotFoundException.class)
    public void shouldThrowItemNotFoundExceptionWhenCheckOutingUnExistentItem() throws ItemNotFoundException {
        library.checkOutItem(0);
    }

    @Test
    public void shouldGiveBackItem() throws ItemNotFoundException {
        library.checkOutItem(1);
        Boolean giveBackWithSuccess = library.giveBackItem(1);

        assertEquals(giveBackWithSuccess, true);
    }

    @Test(expected = ItemNotFoundException.class)
    public void shouldThrowItemNotFoundExceptionWhenGiveBackingUnExistentItem() throws ItemNotFoundException {
        library.giveBackItem(0);
    }
}
