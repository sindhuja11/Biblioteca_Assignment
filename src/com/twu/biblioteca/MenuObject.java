package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by sindhum on 21/01/15.
 */
public class MenuObject {
   HashMap<Integer,Object> menuObject=new HashMap<Integer, Object>();
       public MenuObject(Librarian librarian, BibliotecaApp bibliotecaApp, Login login, User user) {
        menuObject.put(1,new DisplayBookList(librarian));
        menuObject.put(2,new CheckOutBook(librarian,login));
        menuObject.put(3,new ReturnBook(librarian,login));
        menuObject.put(4,new Quit(bibliotecaApp));
        menuObject.put(5,new DisplayMovieList(librarian));
        menuObject.put(6,new CheckOutMovie(librarian,login));
        menuObject.put(7,new LoginOption(user,login,librarian));
        menuObject.put(8,new ReturnMovie(librarian,login));
        menuObject.put(9,new DisplayCheckOutList(librarian));

    }
        public Object giveObject (int option){
        return menuObject.get(option);
    }

}
