package com.example.demo.model;

public class User {
private int id;
private static int nextId = 1;
private String username;
private String password;
private UserRole role;

    public User(int id, String username, String password) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(){
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
