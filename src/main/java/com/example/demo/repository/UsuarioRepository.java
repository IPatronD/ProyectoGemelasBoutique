package com.example.demo.repository;

import com.example.demo.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// Repositorio de Usuario
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    // Buscar usuario por username
    Optional<Usuario> findByUsername(String username);

    // Verificar si existe username
    boolean existsByUsername(String username);

    // Listar usuarios por estado
    List<Usuario> findByEstado(boolean estado);

    // Buscar usuarios por nombre de rol
    @Query("""
            SELECT u FROM Usuario u
            JOIN u.roles r
            WHERE r.nombre = :rol
            """)
    List<Usuario> buscarPorRol(
            @Param("rol") String rol);
}