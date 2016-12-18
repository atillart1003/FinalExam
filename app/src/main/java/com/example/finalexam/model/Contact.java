package com.example.finalexam.model;

/**
 * Created by Kittichai on 18/12/2559.
 */

public class Contact {
    private String mName;
    private String mUser;
    private String mPass;

    public Contact(String name, String user, String pass) {
        this.mName = name;
        this.mUser = user;
        this.mPass = pass;
    }

    public String getUser() {
        return mUser;
    }

    public String getName() {
        return mName;
    }

    public String getPass() {
        return mPass;
    }

    @Override
    public String toString() {
        return mName;
    }
}
