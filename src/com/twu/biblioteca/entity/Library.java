package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Item> items;

    public Library() {
        this.items = new ArrayList<Item>();
        addBooksDefault();
    }

    private void addBooksDefault() {
        items.add(new Book(1, "Robert Martin", 2008, "Clean Code"));
        items.add(new Book(2, "Andrew Hunt", 1999, "The Pragmatic Programmer"));
        items.add(new Book(3, "Robert Martin", 2011, "The Clean Coder"));
        items.add(new Movie(4, "Quentin Tarantino", 2013, "Django Unchained", 10));
        items.add(new Movie(5, "Quentin Tarantino", 2016, "The Hateful Eight", 10));
    }


    public List<Item> listItems() {
        return this.items;
    }

    public List<Item> listAvailableItems() {
        List<Item> availableItems = new ArrayList<Item>();
        for (Item item : this.items) {
            if (item.getAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public Boolean checkOutItem(Integer itemId) throws ItemNotFoundException {
        Boolean checkOutWithSuccess = false;
        Item item = getItemBy(itemId);
        if (item.getAvailable()) {
            item.checkOut();
            checkOutWithSuccess = true;
        }
        return checkOutWithSuccess;
    }

    public Boolean giveBackItem(Integer itemId) throws ItemNotFoundException {
        Boolean giveBackSuccess = false;
        Item item = getItemBy(itemId);
        if (!item.getAvailable()) {
            item.giveBack();
            giveBackSuccess = true;
        }
        return giveBackSuccess;
    }

    private Item getItemBy(Integer id) throws ItemNotFoundException {
        for (Item item : this.items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        throw new ItemNotFoundException(id);
    }
}
