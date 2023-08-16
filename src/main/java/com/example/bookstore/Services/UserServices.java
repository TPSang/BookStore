package com.example.bookstore.Services;

import com.example.bookstore.DTO.LoginRequest;
import com.example.bookstore.DTO.ResignBody;
import com.example.bookstore.Dao.UsersDao;
import com.example.bookstore.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service

public class UserServices {
    @Autowired
    UsersDao usersDao;
    @Autowired
    EncrypPassword encryptionService;

    public void Users() {}

    public Users registerUser(@RequestBody ResignBody resignBody) {
        Users newUser = new Users();
        newUser.setUsername(resignBody.getUsername());
        newUser.setEmail(resignBody.getEmail());
        newUser.setFistname(resignBody.getFistname());
        newUser.setLastname(resignBody.getLastname());
        newUser.setPhone(resignBody.getPhone());

        newUser.setPassword(encryptionService.encrypPassword(resignBody.getPassword()));
        // Lưu người dùng mới vào cơ sở dữ liệu
        return usersDao.save(newUser);
    }
    public Users loginUser(LoginRequest loginRequest) {
        Users user = usersDao.findByUsername(loginRequest.getUsername());

        if (user != null && encryptionService.verifyPassword(loginRequest.getPassword(), user.getPassword())) {
            return user;
        }

        return null; // Đăng nhập không thành công
    }


    public Users getUserByUsername(String username) {
        return usersDao.findByUsername(username);
    }
}
