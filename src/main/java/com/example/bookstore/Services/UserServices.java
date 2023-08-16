package com.example.bookstore.Services;

import com.example.bookstore.DTO.LoginBody;
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


//     public boolean authUser(LoginBody loginBody) {
//        Users user = usersDao.findByUsername(loginBody.getUsername());
//        if (user != null && user.getPassword().equals(loginBody.getPassword())) {
//            return true; // Đăng nhập thành công
//        }
//        return false; // Đăng nhập thất bại
//    }
public  Boolean loginUser(LoginBody loginBodybody){
    Optional<Users> optionalUsers =usersDao.findByUsernameIgnoreCase(loginBodybody.getUsername());
    if(optionalUsers.isPresent()){
        Users users = optionalUsers.get();
        if(encryptionService.verifyPassword(loginBodybody.getPassword(),users.getPassword())){
            return true;
        }
    }
    return false;
}
}
