package com.example.bookstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResignBody {
    private String username;
    private String password;
    private String email;
    private String fistname;
    private String lastname;
    private Integer phone;
}
