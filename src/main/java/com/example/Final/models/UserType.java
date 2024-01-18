package com.example.Final.models;

public enum UserType {
    USER("User"),
    ADMIN("Admin"),
    MODERATOR("Moderator"),
    GUEST("Guest");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
