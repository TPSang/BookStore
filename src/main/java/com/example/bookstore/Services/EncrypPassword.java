package com.example.bookstore.Services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncrypPassword {


    // Set value cho ma hoa value cang lon ma hoa cang manh
    @Value("${encryption.salt.rounds}")

    // luu valu da tao
    private int saltRounds;

    //bien tao values
    private String salt;

    //tao ra ma hoa

    @PostConstruct
    public void postConstruct(){
        salt = BCrypt.gensalt(saltRounds);
    }


    //mã hoa mat khau
    public String encrypPassword(String password){
        return BCrypt.hashpw(password,salt);
    }
    // gia mai mat khau
    public boolean verifyPassword(String password , String hash){
        return BCrypt.checkpw(password, hash);
    }
}

