package com.example.bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "fistname")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String fistname;

    @Column(name = "lastname")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String lastname;

    @Column(name = "phone", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer phone;

//    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Address> address = new ArrayList<>();

}