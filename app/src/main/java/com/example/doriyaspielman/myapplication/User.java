package com.example.doriyaspielman.myapplication;

public class User {

    private String user_name;
    private String email;
    private String password;
    private boolean  manager;

    public User(){

    }

    public User(String user_name, String email, String password, boolean  manager) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.manager = manager;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean  manager) {
        this.manager = manager;
    }
}
