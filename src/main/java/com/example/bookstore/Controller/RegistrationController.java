package com.example.bookstore.Controller;

import com.example.bookstore.DTO.ResignBody;
import com.example.bookstore.Model.Users;
import com.example.bookstore.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserServices userServices;
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("resignBody", new ResignBody());
        return "/User/registration-form"; // Tên của tệp .html chứa form
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@ModelAttribute("resignBody") ResignBody resignBody) {
        Users newUser = userServices.registerUser(resignBody);
        if (newUser != null) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }
}
