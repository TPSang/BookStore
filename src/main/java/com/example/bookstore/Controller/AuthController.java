package com.example.bookstore.Controller;
import com.example.bookstore.DTO.LoginRequest;
import com.example.bookstore.Model.Users;
import com.example.bookstore.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


// Tạo lớp controller cho việc đăng nhậjp
@Controller
public class AuthController {
    @Autowired
    UserServices userServices;

    // Gọi trang đăng nhập
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // Set model qua DTO LoginRequest
        model.addAttribute("loginRequest", new LoginRequest());
        return "User/login";
    }

    // Thực hiện đăng nhập
    @PostMapping("/login")
    public String login(LoginRequest loginRequest, Model model) {
        // Set user đăng nhập quan DTO loginRequest gọi hàm loginUser trong UserService
        Users user = userServices.loginUser(loginRequest);
        // Nếu Service trả về user
        if (user != null) {
            // set model cho user đuược trả về
            model.addAttribute("user", user);
            System.out.println(user);
            // Trả về trang chủ
            return "User/success"; // Đăng nhập thành công
        } else {
            // nếu sai trả về trang login cùng thông báo
            model.addAttribute("-", true);
            return "User/login"; // Đăng nhập thất bại, hiển thị lại form
        }
    }
}
