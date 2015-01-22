package com.twu.biblioteca;

/**
 * Created by sindhum on 21/01/15.
 */
public class DisplayCheckOutList extends MenuController{
    Librarian librarian;

    public DisplayCheckOutList(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public void doAction() {
        librarian.displayCheckOutList();
    }
}
