package com.example.bookstore.Controller;


import com.example.bookstore.DTO.LoginBody;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserServices usersService;


    @GetMapping("/login-form")
    public String showLoginForm() {
        return "User/login-form";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        LoginBody loginBody = new LoginBody(username, password);
        boolean isAuthenticated = usersService.loginUser(loginBody);

        if (isAuthenticated) {
            model.addAttribute("loginResult", "Login successful");
        } else {
            model.addAttribute("loginResult", "Login failed");
        }

        return "User/login-form";
    }



}





