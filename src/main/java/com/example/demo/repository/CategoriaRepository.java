package com.example.demo.repository;

import com.example.demo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//BY JAMES

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}
