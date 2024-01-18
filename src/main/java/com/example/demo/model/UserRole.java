package com.example.demo.model;

public enum UserRole {
    REGULAR("Regular"),
    ADMIN("Admin");
    private final String displayRole;

    UserRole(String displayRole) {
        this.displayRole = displayRole;
    }
    public String getDisplayRole(){
        return displayRole;
    }
}
