package com.twu.biblioteca;

/**
 * Created by sindhum on 21/01/15.
 */
public class Quit extends MenuController{
    BibliotecaApp bibliotecaApp;

    public Quit(BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
    }

    @Override
    public void doAction() {
        bibliotecaApp.quit();
    }
}
