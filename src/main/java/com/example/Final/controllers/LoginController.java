package com.example.Final.controllers;

import com.example.Final.data.UserRepository;
import com.example.Final.models.Role;
import com.example.Final.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import the BCryptPasswordEncoder

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inject the BCryptPasswordEncoder bean

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        // Set default role

        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Save user
        userRepository.save(user);
        return "redirect:/login";  // Redirect to login page after registration
    }
}
