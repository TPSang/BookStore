package com.example.bookstore.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "procducts")
public class Procducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String description;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @OneToOne(mappedBy = "procducts", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

}