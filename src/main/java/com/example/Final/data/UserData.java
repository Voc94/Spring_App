package com.example.Final.data;

import com.example.Final.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    //need a place to put Users
    private static final Map<Integer, User> users = new HashMap<>();

    // get all users
    public static Collection<User> getAll(){
        return users.values();
    }
    // get a single user
    public static User getById(int id){
        return users.get(id);
    }
    // add an user
    public static void add(User user){
        users.put(user.getId(),user);
    }

    // remove an user
    public static void remove(int id){
        users.remove(id);
    }
}
