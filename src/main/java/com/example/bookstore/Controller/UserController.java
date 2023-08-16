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

@Controller
public class UserController {

    @Autowired
    UserServices usersService;

    @GetMapping("/users")
    public String showLoginForm(Model model){
        model.addAttribute("loginBody", new LoginBody());
        return "/User/login-form";
    };
    @PostMapping("/api/login")
    public ResponseEntity<String> loginUser(@ModelAttribute("loginBody") LoginBody loginBody) {
        // Sử dụng
        loginBody.getUsername() ;
        loginBody.getPassword() ;
        usersService.authUser(loginBody);
        // Trả về phản hồi phù hợp
        return ResponseEntity.ok("Login successful");
    }





}





