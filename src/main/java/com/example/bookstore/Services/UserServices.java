package com.example.bookstore.Services;

import com.example.bookstore.DTO.LoginBody;
import com.example.bookstore.DTO.ResignBody;
import com.example.bookstore.Dao.UsersDao;
import com.example.bookstore.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class UserServices {
    @Autowired
    UsersDao usersDao;

    public void Users() {}

    public Users registerUser(@RequestBody ResignBody resignBody) {
        Users newUser = new Users();
        newUser.setUsername(resignBody.getUsername());
        newUser.setPassword(resignBody.getPassword());
        newUser.setEmail(resignBody.getEmail());
        newUser.setFistname(resignBody.getFistname());
        newUser.setLastname(resignBody.getLastname());
        newUser.setPhone(resignBody.getPhone());

        // Lưu người dùng mới vào cơ sở dữ liệu
        return usersDao.save(newUser);
    }


    public boolean authUser(LoginBody loginBody) {
        Users user = usersDao.findByUsername(loginBody.getUsername());
        if (user != null && user.getPassword().equals(loginBody.getPassword())) {
            return true; // Đăng nhập thành công
        }
        return false; // Đăng nhập thất bại
    }
}
