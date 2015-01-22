package com.twu.biblioteca;

/**
 * Created by sindhum on 21/01/15.
 */
public class DisplayMovieList extends MenuController {
    Librarian librarian;

        public DisplayMovieList(Librarian librarian) {
            this.librarian=librarian;
        }

        @Override
        public void doAction() {
            librarian.giveMovieList();
        }
    }

