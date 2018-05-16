package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Item> items;
    private List<User> users;
    private User currentUser;

    public Library() {
        this.items = new ArrayList<Item>();
        addItemsDefault();
        addUsers();
    }

    private void addUsers() {
        this.users = Arrays.asList(new User("João", "joao@email.com", "1234", "99999"), new User("Maria", "maria@email.com", "1234", "99999"));
    }

    private void addItemsDefault() {
        this.items.add(new Book(1, "Robert Martin", 2008, "Clean Code"));
        this.items.add(new Book(2, "Andrew Hunt", 1999, "The Pragmatic Programmer"));
        this.items.add(new Book(3, "Robert Martin", 2011, "The Clean Coder"));
        this.items.add(new Movie(4, "Quentin Tarantino", 2013, "Django Unchained", 10));
        this.items.add(new Movie(5, "Quentin Tarantino", 2016, "The Hateful Eight", 10));
    }

    public List<Item> listNotAvailableItems() {
        List<Item> notAvailableItems = new ArrayList<Item>();
        for (Item item : this.items) {
            if (!item.getAvailable()) {
                notAvailableItems.add(item);
            }
        }
        return notAvailableItems;
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

    public List<User> listUsers() {
        return this.users;
    }

    public Boolean checkOutItem(Integer itemId) throws ItemNotFoundException {
        Boolean checkOutWithSuccess = false;
        Item item = getItemBy(itemId);
        Boolean itemIsNotCheckOut = item.getAvailable();
        Boolean userIsLogged = this.currentUser != null;

        if (itemIsNotCheckOut && userIsLogged) {
            item.checkOut(this.currentUser);
            checkOutWithSuccess = true;
        }
        return checkOutWithSuccess;
    }

    public Boolean giveBackItem(Integer itemId) throws ItemNotFoundException {
        Boolean giveBackSuccess = false;
        Item item = getItemBy(itemId);
        Boolean userLoggedIsTheUserCheckOut = this.currentUser == item.userCheckOut;
        Boolean itemIsCheckOut = !item.getAvailable();

        if (itemIsCheckOut && userLoggedIsTheUserCheckOut) {
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

    public void login(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }
}
