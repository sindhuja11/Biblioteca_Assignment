package com.twu.biblioteca;
/**
 * Created by sindhum on 21/01/15.
 */
public class DisplayBookList extends MenuController {
    Librarian librarian;
    public DisplayBookList(Librarian librarian) {
        this.librarian=librarian;
    }

    @Override
    public void doAction() {
        librarian.giveBookList();
    }
}
