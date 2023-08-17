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

    // Thêm User từ người dùng thông qua DTO ReSignBody
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
    // Hàm đăng nhập user
    public Users loginUser(  LoginRequest loginRequest) {

        // Nhân từ LoginRequest và tìm trong DB
        Users user = usersDao.findByUsername(loginRequest.getUsername());

        //Nếu có người dung và mật khẩu đúng (so sanh mật khẩu từ serviceEncrypassWord)
        if (user != null && encryptionService.verifyPassword(loginRequest.getPassword(), user.getPassword())) {
           // trả về thông tin ngườfi dùng đó cho controllers
            return user;
        }

        return null; // trả về null
    }


    public Users getUserByUsername(String username) {
        return usersDao.findByUsername(username);
    }
}
