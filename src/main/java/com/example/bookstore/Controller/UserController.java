package com.example.bookstore.Controller;


import com.example.bookstore.Model.Users;
import com.example.bookstore.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserServices usersService;

    @GetMapping("/users")
    public String getUser(){

        return "User/Login";
    };
    @GetMapping("/index")
    public String index(){
        return "User/index";
    }
    @GetMapping("/register")
    public String register(){
        return "User/Register";
    }

    @GetMapping("/users/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new Users());
        return "User/create-user";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute Users user) {
        usersService.creUsers(user);
        return "redirect:/users";
    }
}





