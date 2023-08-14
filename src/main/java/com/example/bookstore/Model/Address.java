package com.example.bookstore.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String street;

    @Column(name = "district", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String district;

    @Column(name = "city", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String city;

    @Column(name = "ward")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String ward;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

}