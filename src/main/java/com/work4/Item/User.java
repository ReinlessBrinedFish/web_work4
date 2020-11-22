package com.work4.Item;

import java.io.Serializable;

public class User implements Serializable {
    private String username, password, message;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}