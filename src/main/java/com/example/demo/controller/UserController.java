package com.example.demo.controller;

import com.example.demo.data.UserData;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")

public class UserController {
    @GetMapping
    public String displayAllUsers (Model model) {
        model.addAttribute("title","All Users");
        model.addAttribute("users", UserData.getAll());
        return "users/index";
    }
    // lives at /users/create
    @GetMapping("create")
    public String displayCreateUserForm(Model model){
        model.addAttribute("title","Create User");
        model.addAttribute(new User());
        model.addAttribute("roles", UserRole.values());
        return "users/create";
    }
    // lives at /users/create
    @PostMapping("create")
    public String processCreateUserForm(@ModelAttribute User newUser, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title","Create User");
            return "users/create";
        }
        else {
            UserData.add(newUser);
            return "redirect:/users";
        }
    }
    @GetMapping("delete")
    public String displayDeleteUserForm(Model model){
        model.addAttribute("title","Delete Users");
        model.addAttribute("users",UserData.getAll());
        return "users/delete";
    }
    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds) {
        if(userIds != null)
            for (int id : userIds) {
                UserData.remove(id);
            }
        return "redirect:/users";
    }
}
