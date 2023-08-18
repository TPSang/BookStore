package com.example.bookstore.Dao;

import com.example.bookstore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailIgnoreCase(String email);
    Optional<Users> findByUsernameIgnoreCase(String username);
    Users findByUsername(String username);

}
