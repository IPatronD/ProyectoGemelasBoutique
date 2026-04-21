package com.example.demo.repository;

import com.example.demo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
//BY JAMES

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
