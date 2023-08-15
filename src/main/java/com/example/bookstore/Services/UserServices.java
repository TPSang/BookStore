package com.example.bookstore.Services;

import com.example.bookstore.Dao.UsersDao;
import com.example.bookstore.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServices {
    @Autowired
    UsersDao usersDao;

    public void Users() {}

    public Users creUsers(Users user) {
        return usersDao.save(user);
    }
}
