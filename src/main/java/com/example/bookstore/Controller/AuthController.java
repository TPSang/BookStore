package com.example.bookstore.Controller;
import com.example.bookstore.DTO.LoginRequest;
import com.example.bookstore.Model.Users;
import com.example.bookstore.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {
    @Autowired
    UserServices userServices;

    @GetMapping("/success")
    public  String index(){
        return "User/success";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "User/login";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, Model model) {
        Users user = userServices.loginUser(loginRequest);

        if (user != null) {
            model.addAttribute("user", user);
            System.out.println(user);
            return "redirect:/success"; // Đăng nhập thành công
        } else {
            model.addAttribute("loginError", true);
            return "User/login"; // Đăng nhập thất bại, hiển thị lại form
        }
    }
}
