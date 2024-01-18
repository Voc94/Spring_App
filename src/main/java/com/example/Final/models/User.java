package com.example.Final.models;

import lombok.*;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
@Entity
public class User extends AbstractEntity {
    @Id
    private int id;
    private static int nextId = 1;
    @NonNull
    @Column(unique = true)
    private String name;
    @NonNull
    private String password;
    private UserType type;
    public User(String name, String password, UserType type) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.id = nextId;
        nextId++;
    }

    public User() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
