package com.example.bookstore.Dao;

import com.example.bookstore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Long> {
}
