package com.example.bookstore.Controller;

import com.example.bookstore.DTO.LoginBody;
import com.example.bookstore.Model.Users;
import com.example.bookstore.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserServices usersService;

    @GetMapping("/home")
    public String home() {
        return "User/home";
    }
    @GetMapping("/login-form")
    public String showLoginForm() {
        return "User/login-form";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, Model model) {
//        LoginBody loginBody = new LoginBody(username, password);
//        boolean isAuthenticated = usersService.loginUser(loginBody);
//
//        if (isAuthenticated) {
//            Users user = usersService.getUserByUsername(username);
//            model.addAttribute("loggedInUser", user);
//            model.addAttribute("loginResult", "Login successful");
//            return "User/home";
//        } else {
//            model.addAttribute("loginResult", "Login failed");
//            return "User/login-form";
//        }
//    }
@PostMapping("/login")
public ResponseEntity<LoginBody> login(@RequestParam String username, @RequestParam String password , Model model) {
    LoginBody loginBody = new LoginBody(username, password);
    boolean isAuthenticated = usersService.loginUser(loginBody);

    if (isAuthenticated) {
        Users user = usersService.getUserByUsername(username);
        model.addAttribute("loggedInUser", user);

        return ResponseEntity.ok(loginBody);
    } else {
        return ResponseEntity.ok(loginBody);
    }
}

}
