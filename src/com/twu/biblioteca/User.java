package com.twu.biblioteca;

/**
 * Created by sindhum on 16/01/15.
 */
public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String userID;
    private String password;

    public User(String name,String email,String phoneNumber,String userId,String password)
    {
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.userID=userId;
        this.password=password;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getUserID() {
        return userID;
    }
    public String getPassword() {
        return password;
    }

}
