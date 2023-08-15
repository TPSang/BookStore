package com.example.bookstore.Dao;

import com.example.bookstore.Model.Procducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Procducts,Long> {
}
